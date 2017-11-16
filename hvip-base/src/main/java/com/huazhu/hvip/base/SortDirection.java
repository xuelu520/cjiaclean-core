package com.huazhu.hvip.base;

import java.io.Serializable;

/**
 * Created by HUQIANBO001 on 2016/3/25.
 */
public enum SortDirection implements Serializable {

    ASC("ASC"),
    DESC("DESC");

    private String code;

    public String getCode() {
        return this.code;
    }

    private SortDirection(String code) {
        this.code = code;
    }

    public String toString() {
        return this.name();
    }


}
