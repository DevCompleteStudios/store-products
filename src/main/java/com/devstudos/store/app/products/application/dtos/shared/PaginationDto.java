package com.devstudos.store.app.products.application.dtos.shared;

import jakarta.validation.constraints.Min;



public class PaginationDto {

    @Min(value = 1)
    private int offset = 1;

    @Min(value = 0)
    private int limit = 10;


    public int getOffset() {
        return offset;
    }
    public void setOffset(int offset) {
        this.offset = offset;
    }
    public int getLimit() {
        return limit;
    }
    public void setLimit(int limit) {
        this.limit = limit;
    }

}
