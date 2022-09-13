package com.cts.servicebookingmanagement.model;

public class Response {
    private String message;
    private AppServiceReq appServiceReq;

    public Response() {
    }

    public Response(String message, AppServiceReq appServiceReq) {
        this.message = message;
        this.appServiceReq = appServiceReq;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public AppServiceReq getAppServiceReq() {
        return appServiceReq;
    }

    public void setAppServiceReq(AppServiceReq appServiceReq) {
        this.appServiceReq = appServiceReq;
    }
}
