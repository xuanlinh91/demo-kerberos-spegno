package jp.co.ntt.common.dto.request.datatable.accounting;

import lombok.Data;

@Data
public class DataTableSearchCriteria {

    private String value;

    private boolean regex;
}