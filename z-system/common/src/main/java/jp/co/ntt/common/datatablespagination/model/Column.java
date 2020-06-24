package jp.co.ntt.common.datatablespagination.model;

import lombok.Data;

@Data
public class Column {

	private String data;

	private String name;

	private boolean searchable;

	private boolean orderable;

	private SearchCriteria search;

}