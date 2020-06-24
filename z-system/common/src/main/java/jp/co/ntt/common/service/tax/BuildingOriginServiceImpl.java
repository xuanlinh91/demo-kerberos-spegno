package jp.co.ntt.common.service.tax;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.ntt.common.datatablespagination.model.PaginationCriteria;
import jp.co.ntt.common.entity.fatpc.tax.master.BuildingOriginViewEntity;
import jp.co.ntt.common.repository.fatpc.tax.master.BuildingOriginViewRepository;

@Service
public class BuildingOriginServiceImpl implements BuildingOriginService {

	private long countTotalEntries;
	private String searchAddMatch = "";
	private Boolean isSearchAddMatch = false;

	@Autowired()
	private BuildingOriginViewRepository buildingOriginRepository;

	@Override
	public List<BuildingOriginViewEntity> getPageEntries(PaginationCriteria paginationCriteria) {

		var year = String.valueOf(paginationCriteria.getYear());
		var month = String.format("%02d", paginationCriteria.getMonth());

		var bldgErrBldgItemList = buildingOriginRepository.findBuildingOriginWithPagesize(paginationCriteria.getStart(),
				paginationCriteria.getLength(), year, year + month, paginationCriteria.getSearchCond2(),
				paginationCriteria.getSearchCond3(), paginationCriteria.getSearchCond4(), isSearchAddMatch,
				searchAddMatch);

		return bldgErrBldgItemList;
	}

	@Override
	public long countTotalEntries(PaginationCriteria paginationCriteria) {
		var year = String.valueOf(paginationCriteria.getYear());
		var month = String.format("%02d", paginationCriteria.getMonth());

		countTotalEntries = 0;
		isSearchAddMatch = false;
		searchAddMatch = "";

		if (paginationCriteria.getSearchCond1() != null) {
			var findArr = FindAddress.splitAddress(paginationCriteria.getSearchCond1());
			if (findArr != null && findArr.length > 0) {
				isSearchAddMatch = true;
				for (var i = 0; i < findArr.length - 1; i++) {
					if (i > 0) {
						searchAddMatch += "%";
					}
					searchAddMatch += findArr[i];
				}

			} else {
				isSearchAddMatch = false;
				searchAddMatch = "";
			}
		}

		var count = buildingOriginRepository.countBuildingOrigin(year, year + month,
				paginationCriteria.getSearchCond2(), paginationCriteria.getSearchCond3(),
				paginationCriteria.getSearchCond4(), isSearchAddMatch, searchAddMatch);
		countTotalEntries = count;
		return count;
	}

	@Override
	public long countFilteredEntries(PaginationCriteria paginationCriteria) {
		return countTotalEntries;
	}
}
