package jp.co.ntt.common.service.tax;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.ntt.common.constant.DbPurposeDefinition;
import jp.co.ntt.common.constant.TieUpErrWarnTypeDefinition;
import jp.co.ntt.common.datatablespagination.model.PaginationCriteria;
import jp.co.ntt.common.dto.tax.bldg.BldgErrBldgListView;
import jp.co.ntt.common.dto.tax.bldg.BldgErrListUpdate;
import jp.co.ntt.common.dto.tax.bldg.BldgErrUpdate;
import jp.co.ntt.common.dto.tax.master.BldgErrBldgErrorWarning;
import jp.co.ntt.common.entity.fatpc.tax.master.BuildingOriginEntity;
import jp.co.ntt.common.entity.zsystem.master.BuildingCorrectionEntity;
import jp.co.ntt.common.entity.zsystem.master.BuildingCorrectionPK;
import jp.co.ntt.common.entity.zsystem.master.DispatchTieUpEntity;
import jp.co.ntt.common.entity.zsystem.master.FloorAreaTieUpEntity;
import jp.co.ntt.common.repository.fatpc.tax.master.BuildingOriginRepository;
import jp.co.ntt.common.repository.fatpc.tax.master.CompanyListNTTWMissionRepository;
import jp.co.ntt.common.repository.fatpc.tax.td.DataVersionViewRepository;
import jp.co.ntt.common.repository.fatpc.tax.td.TieUpErrorWarningDataRepository;
import jp.co.ntt.common.repository.zsystem.master.BuildingCorrectionRepository;
import jp.co.ntt.common.repository.zsystem.master.DbPurposeRepository;
import jp.co.ntt.common.repository.zsystem.master.DispatchTieUpRepository;
import jp.co.ntt.common.repository.zsystem.master.ErrorWarningRepository;
import jp.co.ntt.common.repository.zsystem.master.FloorAreaTieUpRepository;

@Service
public class BldgErrServiceImpl implements BldgErrService {

	@Autowired()
	private DbPurposeRepository dbPurposeRepository;

	@Autowired()
	private ErrorWarningRepository errorWarningRepository;

	@Autowired()
	private TieUpErrorWarningDataRepository tieUpErrorWarningDataRepository;

	@Autowired()
	private DataVersionViewRepository dataVersionViewRepository;

	@Autowired()
	private DispatchTieUpRepository dispatchTieUpRepository;

	@Autowired()
	private FloorAreaTieUpRepository floorAreaTieUpRepository;

	@Autowired()
	private BuildingCorrectionRepository buildingCorrectionRepository;

	@Autowired()
	private BuildingOriginRepository buildingOriginRepository;

	@Autowired()
	private CompanyListNTTWMissionRepository companyListNTTWMissionRepository;

	@Override
	public List<BldgErrBldgListView> finBldgErrData(int tieupType, int order, PaginationCriteria paginationCriteria) {

		var bldgErrBldgItemList = new ArrayList<BldgErrBldgListView>();
		var year = String.valueOf(paginationCriteria.getYear());
		var month = String.format("%02d", paginationCriteria.getMonth());

		// 地方税DBチェック
		int cntTaxDbPurpose = dbPurposeRepository.findDbPurpose(DbPurposeDefinition.TAX);
		if (cntTaxDbPurpose == 0) {
			return bldgErrBldgItemList;
		}

		var tieUpErrWarnDtList = tieUpErrorWarningDataRepository.findTieUpErrorWarningDataWithPagesize(tieupType,
				paginationCriteria.getStart(), paginationCriteria.getLength(), year, month, order);

		if (tieUpErrWarnDtList.size() == 0)
			return bldgErrBldgItemList;

		var errWarnDtIdList = tieUpErrWarnDtList.stream().map(x -> x.getErrorWarningId()).distinct()
				.collect(Collectors.toList());

		var errWarnList = new ArrayList<BldgErrBldgErrorWarning>();
		var dataVerList = dataVersionViewRepository.findDataVersion(year, year + month);
		for (var dataVer : dataVerList) {
			var errWarnFindList = errorWarningRepository.findErrorWarning(year, year + month, dataVer.getReportId(),
					dataVer.getIncrementalFlag(), dataVer.getVersion(), errWarnDtIdList);
			errWarnList.addAll(errWarnFindList);
		}

		for (var tie : tieUpErrWarnDtList) {
			var errWarnDt = errWarnList.stream()
					.filter(e -> tie.getErrorWarningId().intValue() == e.getErrorWarningId()).findFirst().orElse(null);
			if (errWarnDt != null) {
				BldgErrBldgListView bldgErrBldgListView = null;
				if (tieupType == TieUpErrWarnTypeDefinition.BUILDING) {
					bldgErrBldgListView = new BldgErrBldgListView(tie.getStatus(), tie.getBuildingCode(),
							tie.getBuildingName(), null, errWarnDt.getErrorWarningContent(),
							errWarnDt.getCorrespondence(), tie.getErrorWarningDataIds());
				} else if (tieupType == TieUpErrWarnTypeDefinition.OTHER_DISPATCH) {
					bldgErrBldgListView = new BldgErrBldgListView(tie.getStatus(), tie.getBuildingCode(),
							tie.getBuildingName(), tie.getBuildingAddress(), errWarnDt.getErrorWarningContent(),
							errWarnDt.getCorrespondence(), tie.getErrorWarningDataIds());
				} else if (tieupType == TieUpErrWarnTypeDefinition.FLOOR_AREA) {
					bldgErrBldgListView = new BldgErrBldgListView(tie.getStatus(), tie.getBuildingCode(),
							tie.getBuildingName(), tie.getBuildingAddress(), errWarnDt.getErrorWarningContent(),
							errWarnDt.getCorrespondence(), tie.getErrorWarningDataIds());
				}

				bldgErrBldgItemList.add(bldgErrBldgListView);
			}
		}

		return bldgErrBldgItemList;
	}

	@Override
	public long countBldgErrData(int tieupType, PaginationCriteria paginationCriteria) {

		var year = String.valueOf(paginationCriteria.getYear());
		var month = String.format("%02d", paginationCriteria.getMonth());
		var count = tieUpErrorWarningDataRepository.countTieUpErrorWarningData(tieupType, year, month);

		return count;
	}

	@Override
//	@Transactional(value = "zsystemTransactionManager")
	public void updateBldgErrData(BldgErrListUpdate bldgErrListUpdate, int tieupType) {

		var year = String.valueOf(bldgErrListUpdate.getAccPeriod().getYear());
		var month = String.format("%02d", bldgErrListUpdate.getAccPeriod().getMonth());

		for (BldgErrUpdate bldg : bldgErrListUpdate.getBldgErrList()) {

			// ビルマスタ(原本)
			var bldgOrg = buildingOriginRepository.findById(Integer.valueOf(bldg.getBldgOrgDtId()));
			if (bldgOrg.isEmpty()) {
				continue;
			}

			// ビルマスタ(補正後)
			var bldgCorr = buildingOriginRepository.findById(Integer.valueOf(bldg.getBldgCorrDtId()));
			if (bldgCorr.isEmpty()) {
				continue;
			}

			if (tieupType == TieUpErrWarnTypeDefinition.OTHER_DISPATCH) {
				// その他派遣紐付けマスタTBLに追加
				addDispatchTieUp(year, month, bldg, bldgOrg.get(), bldgCorr.get());
			} else if (tieupType == TieUpErrWarnTypeDefinition.FLOOR_AREA) {
				// 床面積紐付けマスタTBLに追加
				addFloorAreaTieUp(year, month, bldg, bldgOrg.get(), bldgCorr.get());
			}

			// ビルマスタ(補正後)TBLに追加
			var errWarnDtIds = bldg.getErrWarnDtIds().split(",");
			for (var errWarnDtId : errWarnDtIds) {

				var tieUpErrWarnDt = tieUpErrorWarningDataRepository.findById(Integer.valueOf(errWarnDtId));
				if (tieUpErrWarnDt.isEmpty()) {
					continue;
				}

				var cmpName = companyListNTTWMissionRepository.findCompanyName(
						bldgErrListUpdate.getAccPeriod().getYear(), year + month,
						tieUpErrWarnDt.get().getCompanyCode());

				var bldgCorrPK = new BuildingCorrectionPK();
				bldgCorrPK.setAccountPeriodYear(year);
				bldgCorrPK.setAccountPeriodMonth(month);
				bldgCorrPK.setCompanyBuidingCode(tieUpErrWarnDt.get().getCompanyCode()
						+ bldgOrg.get().getBuildingCodeOrigin() + bldgOrg.get().getBuildingNameOrigin());
				var bldgCorrAdd = new BuildingCorrectionEntity();
				bldgCorrAdd.setId(bldgCorrPK);
				bldgCorrAdd.setCompanyCode(tieUpErrWarnDt.get().getCompanyCode());
				bldgCorrAdd.setCompanyName(cmpName);
				bldgCorrAdd.setBuildingCode(bldgOrg.get().getBuildingCodeOrigin());
				bldgCorrAdd.setBuildingName(bldgOrg.get().getBuildingNameOrigin());
				bldgCorrAdd.setAddress(bldgOrg.get().getAddress());
				bldgCorrAdd.setCorporateInhabitantTaxCorrection(bldgOrg.get().getCorporateInhabitantTaxOrigin());
				bldgCorrAdd.setPrefectureCorrection(bldgOrg.get().getPrefectureOrigin());
				bldgCorrAdd.setMunicipalityCorrection(bldgOrg.get().getMunicipalityOrigin());
				bldgCorrAdd.setBuildingCodeCorrection(bldgCorr.get().getBuildingCodeOrigin());
				bldgCorrAdd.setBuildingNameCorrection(bldgCorr.get().getBuildingNameCodeOrigin());
				bldgCorrAdd.setAddressCorrection(bldgCorr.get().getAddress());

				buildingCorrectionRepository.save(bldgCorrAdd);

				// 紐付けエラーワーニングデータを削除する
				tieUpErrorWarningDataRepository.deleteById(Integer.valueOf(errWarnDtId));
			}
		}
	}

	@Override
	public void addDispatchTieUp(String year, String month, BldgErrUpdate bldg, BuildingOriginEntity bldgOrg,
			BuildingOriginEntity bldgCorr) {
		// その他派遣紐付けマスタTBLに追加
		var dispatch = new DispatchTieUpEntity();
		dispatch.setAccountPeriodYear(year);
		dispatch.setAccountPeriodMonth(month);
		// ビル(その他派遣)
		dispatch.setBuildingNameDispatch(bldg.getBldgNm());
		dispatch.setBuildingAddressDispatch(bldg.getBldgAdd());
		// ビルマスタ(原本)
		dispatch.setBuildingCodeOrigin(bldgOrg.getBuildingCodeOrigin());
		dispatch.setBuildingNameOrigin(bldgOrg.getBuildingNameCodeOrigin());
		dispatch.setBuildingAddressOrigin(bldgOrg.getAddress());
		dispatch.setCorporateInhabitantTaxCorrection(bldgOrg.getCorporateInhabitantTaxOrigin());
		dispatch.setPrefectureCorrection(bldgOrg.getPrefectureOrigin());
		dispatch.setMunicipalityCorrection(bldgOrg.getMunicipalityOrigin());
		// ビルマスタ(補正後)
		dispatch.setBuildingCodeCorrection(bldgCorr.getBuildingCodeOrigin());
		dispatch.setBuildingNameCorrection(bldgCorr.getBuildingNameCodeOrigin());
		dispatch.setBuildingAddressCorrection(bldgCorr.getAddress());

		dispatchTieUpRepository.save(dispatch);
	}

	@Override
	public void addFloorAreaTieUp(String year, String month, BldgErrUpdate bldg, BuildingOriginEntity bldgOrg,
			BuildingOriginEntity bldgCorr) {
		// 床面積紐付けマスタTBLに追加
		var floor = new FloorAreaTieUpEntity();
		floor.setAccountPeriodYear(year);
		floor.setAccountPeriodMonth(month);
		// ビル(その他派遣)
		floor.setBuildingNameFloorArea(bldg.getBldgNm());
		floor.setBuildingAddressFloorArea(bldg.getBldgAdd());
		// ビルマスタ(原本)
		floor.setBuildingCodeOrigin(bldgOrg.getBuildingCodeOrigin());
		floor.setBuildingNameOrigin(bldgOrg.getBuildingNameCodeOrigin());
		floor.setBuildingAddressOrigin(bldgOrg.getAddress());
		floor.setCorporateInhabitantTaxCorrection(bldgOrg.getCorporateInhabitantTaxOrigin());
		floor.setPrefectureCorrection(bldgOrg.getPrefectureOrigin());
		floor.setMunicipalityCorrection(bldgOrg.getMunicipalityOrigin());
		// ビルマスタ(補正後)
		floor.setBuildingCodeDispatch(bldgCorr.getBuildingCodeOrigin());
		floor.setBuildingNameDispatch(bldgCorr.getBuildingNameCodeOrigin());
		floor.setBuildingAddressDispatch(bldgCorr.getAddress());

		floorAreaTieUpRepository.save(floor);
	}
}
