package com.nikola.sportsapp.model.dto;

public class ImageUploadResponseDto {

    private String message;
    private String url;

    public ImageUploadResponseDto() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
