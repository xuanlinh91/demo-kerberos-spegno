package jp.co.ntt.common.datatablespagination.model;

import lombok.Data;

@Data
public class OrderingCriteria {
	public static final String ASC = "asc";
	public static final String DESC = "desc";

	private int column;

	private String dir;

}