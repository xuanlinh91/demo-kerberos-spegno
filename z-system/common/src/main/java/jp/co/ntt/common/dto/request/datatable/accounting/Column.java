package jp.co.ntt.common.dto.request.datatable.accounting;

import lombok.Data;

@Data
public class Column {

	private String data;

	private String name;

	private boolean searchable;

	private boolean orderable;

	private DataTableSearchCriteria search;
}