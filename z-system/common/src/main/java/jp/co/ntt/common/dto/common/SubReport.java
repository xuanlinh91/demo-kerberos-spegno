package jp.co.ntt.common.dto.common;

import lombok.Data;

@Data
public class SubReport {

    private int id;

    private String name;

    public SubReport(int id, String name) {
        this.id = id;
        this.name = name;
    }
}