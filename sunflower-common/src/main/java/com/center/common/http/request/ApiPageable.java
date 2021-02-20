package com.center.common.http.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class ApiPageable implements Serializable {

    private int startPage = 0;

    private int pageSize = 10;

    public void setStartPage(int startPage) {
        if (startPage > 0) {
            startPage--;
        }
        this.startPage = startPage;
    }
}
