package com.cts.servicebookingmanagement.model;

import java.util.List;

public class ListResponse {
    private String message;
    private List<AppServiceReq> appServiceReq;

    public ListResponse() {
    }

    public ListResponse(String message, List<AppServiceReq> appServiceReq) {
        this.message = message;
        this.appServiceReq = appServiceReq;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<AppServiceReq> getAppServiceReq() {
        return appServiceReq;
    }

    public void setAppServiceReq(List<AppServiceReq> appServiceReq) {
        this.appServiceReq = appServiceReq;
    }
}
