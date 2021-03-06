package jp.co.ntt.common.service.tax;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.ntt.common.constant.BldgErrOrderBy;
import jp.co.ntt.common.constant.TieUpErrWarnTypeDefinition;
import jp.co.ntt.common.datatablespagination.model.OrderingCriteria;
import jp.co.ntt.common.datatablespagination.model.PaginationCriteria;
import jp.co.ntt.common.dto.tax.bldg.BldgErrBldgListView;

@Service
public class BldgErrFloorServiceImpl implements BldgErrFloorService {

	private long countTotalEntries;

	@Autowired()
	private BldgErrService bldgErrService;

	@Override
	public List<BldgErrBldgListView> getPageEntries(PaginationCriteria paginationCriteria) {

		var order = 0;

		// order by
		if (paginationCriteria.getOrder().size() > 0) {
			var pcOrder = paginationCriteria.getOrder().get(0);
			if (pcOrder.getColumn() == 0) {
				order = pcOrder.getDir().equals(OrderingCriteria.ASC) ? BldgErrOrderBy.STATUS_ASC
						: BldgErrOrderBy.STATUS_DESC;

			} else if (pcOrder.getColumn() == 2) {

				order = pcOrder.getDir().equals(OrderingCriteria.ASC) ? BldgErrOrderBy.BUILDING_NAME_ASC
						: BldgErrOrderBy.BUILDING_NAME_DESC;
			} else if (pcOrder.getColumn() == 3) {

				order = pcOrder.getDir().equals(OrderingCriteria.ASC) ? BldgErrOrderBy.BUILDING_ADDRESS_ASC
						: BldgErrOrderBy.BUILDING_ADDRESS_DESC;
			}
		}

		var bldgErrItemList = bldgErrService.finBldgErrData(TieUpErrWarnTypeDefinition.FLOOR_AREA, order,
				paginationCriteria);

		return bldgErrItemList;
	}

	@Override
	public long countTotalEntries(PaginationCriteria paginationCriteria) {
		countTotalEntries = 0;
		var count = bldgErrService.countBldgErrData(TieUpErrWarnTypeDefinition.OTHER_DISPATCH, paginationCriteria);
		countTotalEntries = count;
		return count;
	}

	@Override
	public long countFilteredEntries(PaginationCriteria paginationCriteria) {
		return countTotalEntries;
	}

}
