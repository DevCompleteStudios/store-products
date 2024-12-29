package com.devstudos.store.app.products.application.dtos.shared;


import java.util.List;



public class ResponsePagination<T> extends ResponseDto<List<T>> {
    private Long countElements;


    public ResponsePagination(){}

    public ResponsePagination(int status, List<T> data, Long countElements) {
        super(status, data);
        this.countElements = countElements;
    }

    public Long getCountElements() {
        return countElements;
    }
    public void setCountElements(Long countElements) {
        this.countElements = countElements;
    }

}
