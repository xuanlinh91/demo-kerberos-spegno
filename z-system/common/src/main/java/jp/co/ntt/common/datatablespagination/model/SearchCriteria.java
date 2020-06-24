package jp.co.ntt.common.datatablespagination.model;

import lombok.Data;

@Data
public class SearchCriteria {

	private String value;

	private boolean regex;

}