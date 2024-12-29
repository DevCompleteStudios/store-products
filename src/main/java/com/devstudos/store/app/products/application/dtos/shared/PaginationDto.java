package com.devstudos.store.app.products.application.dtos.shared;

import jakarta.validation.constraints.Min;



public class PaginationDto {

    @Min(value = 0)
    private int page = 0;

    @Min(value = 1)
    private int limit = 10;


    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }
    public int getLimit() {
        return limit;
    }
    public void setLimit(int limit) {
        this.limit = limit;
    }

}
