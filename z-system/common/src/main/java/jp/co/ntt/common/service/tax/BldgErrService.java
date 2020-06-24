package jp.co.ntt.common.service.tax;

import java.util.List;

import jp.co.ntt.common.datatablespagination.model.PaginationCriteria;
import jp.co.ntt.common.dto.tax.bldg.BldgErrBldgListView;
import jp.co.ntt.common.dto.tax.bldg.BldgErrListUpdate;
import jp.co.ntt.common.dto.tax.bldg.BldgErrUpdate;
import jp.co.ntt.common.entity.fatpc.tax.master.BuildingOriginEntity;

public interface BldgErrService {

	public List<BldgErrBldgListView> finBldgErrData(int tieupType, int order, PaginationCriteria paginationCriteria);

	public long countBldgErrData(int tieupType, PaginationCriteria paginationCriteria);

	public void updateBldgErrData(BldgErrListUpdate bldgErrListUpdate, int tieupType);

	public void addDispatchTieUp(String year, String month, BldgErrUpdate bldg, BuildingOriginEntity bldgOrg,
			BuildingOriginEntity bldgCorr);

	public void addFloorAreaTieUp(String year, String month, BldgErrUpdate bldg, BuildingOriginEntity bldgOrg,
			BuildingOriginEntity bldgCorr);

}
