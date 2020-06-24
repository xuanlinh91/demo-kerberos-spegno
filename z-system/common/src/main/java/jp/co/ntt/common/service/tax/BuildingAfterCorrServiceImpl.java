package jp.co.ntt.common.service.tax;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.ntt.common.datatablespagination.model.PaginationCriteria;
import jp.co.ntt.common.entity.fatpc.tax.master.BuildingOriginViewEntity;
import jp.co.ntt.common.repository.fatpc.tax.master.BuildingOriginViewRepository;

@Service
public class BuildingAfterCorrServiceImpl implements BuildingAfterCorrService {

	private long countTotalEntries;

	@Autowired()
	private BuildingOriginViewRepository buildingOriginRepository;

	@Override
	public List<BuildingOriginViewEntity> getPageEntries(PaginationCriteria paginationCriteria) {

		var year = String.valueOf(paginationCriteria.getYear());
		var month = String.format("%02d", paginationCriteria.getMonth());

		var bldgErrBldgItemList = buildingOriginRepository.findBuildingOriginAfterCorrWithPagesize(
				paginationCriteria.getStart(), paginationCriteria.getLength(), year, year + month,
				paginationCriteria.getSearchCond1(), paginationCriteria.getSearchCond2(),
				paginationCriteria.getSearchCond3());

		return bldgErrBldgItemList;
	}

	@Override
	public long countTotalEntries(PaginationCriteria paginationCriteria) {
		var year = String.valueOf(paginationCriteria.getYear());
		var month = String.format("%02d", paginationCriteria.getMonth());

		countTotalEntries = 0;

		var count = buildingOriginRepository.countBuildingOriginAfterCorr(year, year + month,
				paginationCriteria.getSearchCond1(), paginationCriteria.getSearchCond2(),
				paginationCriteria.getSearchCond3());
		countTotalEntries = count;
		return count;
	}

	@Override
	public long countFilteredEntries(PaginationCriteria paginationCriteria) {
		return countTotalEntries;
	}
}
