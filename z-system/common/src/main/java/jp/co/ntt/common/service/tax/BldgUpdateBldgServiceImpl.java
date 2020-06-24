package jp.co.ntt.common.service.tax;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.ntt.common.constant.BuildingCorrectionOrderBy;
import jp.co.ntt.common.datatablespagination.model.OrderingCriteria;
import jp.co.ntt.common.datatablespagination.model.PaginationCriteria;
import jp.co.ntt.common.entity.zsystem.master.BuildingCorrectionViewEntity;
import jp.co.ntt.common.repository.zsystem.master.BuildingCorrectionViewRepository;

@Service
public class BldgUpdateBldgServiceImpl implements BldgUpdateBldgService {

	private long countTotalEntries;

	@Autowired()
	private BuildingCorrectionViewRepository buildingCorrectionViewRepository;

	@Override
	public List<BuildingCorrectionViewEntity> getPageEntries(PaginationCriteria paginationCriteria) {

		var order = 0;
		var year = String.valueOf(paginationCriteria.getYear());
		var month = String.format("%02d", paginationCriteria.getMonth());

		// order by
		if (paginationCriteria.getOrder().size() > 0) {
			var pcOrder = paginationCriteria.getOrder().get(0);
			if (pcOrder.getColumn() == 0) {
				order = pcOrder.getDir().equals(OrderingCriteria.ASC) ? BuildingCorrectionOrderBy.COMPANY_CODE_ASC
						: BuildingCorrectionOrderBy.COMPANY_CODE_DESC;
			} else if (pcOrder.getColumn() == 1) {
				order = pcOrder.getDir().equals(OrderingCriteria.ASC) ? BuildingCorrectionOrderBy.COMPANY_NAME_ASC
						: BuildingCorrectionOrderBy.COMPANY_NAME_DESC;
			} else if (pcOrder.getColumn() == 2) {
				order = pcOrder.getDir().equals(OrderingCriteria.ASC)
						? BuildingCorrectionOrderBy.COMPANY_BUIDING_CODE_ASC
						: BuildingCorrectionOrderBy.COMPANY_BUIDING_CODE_DESC;
			} else if (pcOrder.getColumn() == 3) {
				order = pcOrder.getDir().equals(OrderingCriteria.ASC) ? BuildingCorrectionOrderBy.BUILDING_CODE_ASC
						: BuildingCorrectionOrderBy.BUILDING_CODE_DESC;
			} else if (pcOrder.getColumn() == 4) {
				order = pcOrder.getDir().equals(OrderingCriteria.ASC) ? BuildingCorrectionOrderBy.BUILDING_NAME_ASC
						: BuildingCorrectionOrderBy.BUILDING_NAME_DESC;
			} else if (pcOrder.getColumn() == 5) {
				order = pcOrder.getDir().equals(OrderingCriteria.ASC) ? BuildingCorrectionOrderBy.ADDRESS_ASC
						: BuildingCorrectionOrderBy.ADDRESS_DESC;
			} else if (pcOrder.getColumn() == 6) {
				order = pcOrder.getDir().equals(OrderingCriteria.ASC) ? BuildingCorrectionOrderBy.CHANGED_MONTH_ASC
						: BuildingCorrectionOrderBy.CHANGED_MONTH_DESC;
			} else if (pcOrder.getColumn() == 7) {
				order = pcOrder.getDir().equals(OrderingCriteria.ASC) ? BuildingCorrectionOrderBy.CHANGED_REASON_ASC
						: BuildingCorrectionOrderBy.CHANGED_REASON_DESC;
			}

		}

		var listDt = buildingCorrectionViewRepository.findBuildingCorrectionWithPagesize(paginationCriteria.getStart(),
				paginationCriteria.getLength(), year, month, order);

		return listDt;
	}

	@Override
	public long countTotalEntries(PaginationCriteria paginationCriteria) {
		countTotalEntries = 0;
		var year = String.valueOf(paginationCriteria.getYear());
		var month = String.format("%02d", paginationCriteria.getMonth());
		var count = buildingCorrectionViewRepository.countBuildingCorrection(year, month);
		countTotalEntries = count;
		return count;
	}

	@Override
	public long countFilteredEntries(PaginationCriteria paginationCriteria) {
		return countTotalEntries;
	}

}
