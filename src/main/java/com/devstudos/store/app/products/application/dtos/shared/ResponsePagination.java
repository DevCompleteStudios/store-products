package com.devstudos.store.app.products.application.dtos.shared;

import java.util.List;



public class ResponsePagination<T> extends ResponseDto<List<T>> {
    private Long countElements;
    private int pages;


    public ResponsePagination(int status, List<T> data, Long countElements, int pages) {
        super(status, data);
        this.countElements = countElements;
        this.pages = pages;
    }

    public Long getCountElements() {
        return countElements;
    }
    public void setCountElements(Long countElements) {
        this.countElements = countElements;
    }
    public int getPages() {
        return pages;
    }
    public void setPages(int pages) {
        this.pages = pages;
    }


    
}
