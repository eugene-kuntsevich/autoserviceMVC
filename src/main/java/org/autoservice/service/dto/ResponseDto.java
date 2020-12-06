package org.autoservice.service.dto;

public class ResponseDto {
    private String message;
    private int statusCode;
    private String url;

    public ResponseDto(String message, int statusCode, String url) {
        this.message = message;
        this.statusCode = statusCode;
        this.url = url;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
