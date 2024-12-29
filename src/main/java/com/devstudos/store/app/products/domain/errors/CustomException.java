package com.devstudos.store.app.products.domain.errors;




public class CustomException extends RuntimeException {

    private String error;
    private int status;

    private CustomException(String error, int status){
        super(error);
        this.error = error;
        this.status = status;
    }

    public static CustomException badRequest(String error){
        return new CustomException(error, 400);
    }

    public static CustomException notFound(String error){
        return new CustomException(error, 404);
    }

    public static CustomException internalServerError(String error){
        return new CustomException("Internal server error", 500);
    }


    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }

}
