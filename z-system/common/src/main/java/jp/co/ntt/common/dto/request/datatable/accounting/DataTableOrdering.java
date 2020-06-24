package jp.co.ntt.common.dto.request.datatable.accounting;

import lombok.Data;

@Data
public class DataTableOrdering {
	public static final String ASC = "asc";
	public static final String DESC = "desc";

	private int column;

	private String dir;

}