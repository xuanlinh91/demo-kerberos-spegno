package jp.co.ntt.common.dto.request.datatable.accounting;

import java.util.List;

import lombok.Data;

@Data
public class DataTableCriteria {

	private int draw;

	private int start;

	private int length;

	private DataTableSearchCriteria search;

	private List<DataTableOrdering> order;

	private List<Column> columns;

	private String fiscalPeriod;

	private int subReportNo;
}
