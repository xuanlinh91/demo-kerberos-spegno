package jp.co.ntt.common.datatablespagination.model;

import java.util.List;

import lombok.Data;

@Data
public class PaginationCriteria {

	private int draw;

	private int start;

	private int length;

	private SearchCriteria search;

	private List<OrderingCriteria> order;

	private List<Column> columns;

	private int year;

	private int month;

	private String searchCond1;

	private String searchCond2;

	private String searchCond3;

	private String searchCond4;

	private String searchCond5;
}
