package jp.co.ntt.common.datatablespagination.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
public class TablePage<T> {

	private int draw;

	private long recordsTotal;

	private long recordsFiltered;

	private List<T> data;

	@JsonInclude(Include.NON_EMPTY)
	private String error;

}
