package com.devstudos.store.app.products.application.dtos.shared;


import java.util.List;



public class ResponsePagination<T> extends ResponseDto<List<T>> {
    private int countElements;
    private Long pages;


    public ResponsePagination(){}

    public ResponsePagination(int status, List<T> data, int countElements, Long pages) {
        super(status, data);
        this.countElements = countElements;
        this.pages = pages;
    }

    public int getCountElements() {
        return countElements;
    }
    public void setCountElements(int countElements) {
        this.countElements = countElements;
    }
    public Long getPages() {
        return pages;
    }
    public void setPages(Long pages) {
        this.pages = pages;
    }

}
