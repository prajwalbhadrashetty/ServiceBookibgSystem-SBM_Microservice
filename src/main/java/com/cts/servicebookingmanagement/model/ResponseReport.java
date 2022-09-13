package com.cts.servicebookingmanagement.model;

public class ResponseReport {
    private String message;
    private AppServiceReqReport appServiceReqReport;

    public ResponseReport(String message, AppServiceReqReport appServiceReqReport) {
        this.message = message;
        this.appServiceReqReport = appServiceReqReport;
    }

    public String getMessage() {
        return message;
    }

    public ResponseReport() {
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public AppServiceReqReport getAppServiceReqReport() {
        return appServiceReqReport;
    }

    public void setAppServiceReqReport(AppServiceReqReport appServiceReqReport) {
        this.appServiceReqReport = appServiceReqReport;
    }
}
