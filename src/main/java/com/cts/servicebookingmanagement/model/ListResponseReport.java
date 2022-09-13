package com.cts.servicebookingmanagement.model;

import java.util.List;

public class ListResponseReport {
    private String message;
    private List<AppServiceReqReport> appServiceReqReportList;

    public ListResponseReport() {
    }

    public ListResponseReport(String message, List<AppServiceReqReport> appServiceReqReportList) {
        this.message = message;
        this.appServiceReqReportList = appServiceReqReportList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<AppServiceReqReport> getAppServiceReqReportList() {
        return appServiceReqReportList;
    }

    public void setAppServiceReqReportList(List<AppServiceReqReport> appServiceReqReportList) {
        this.appServiceReqReportList = appServiceReqReportList;
    }
}
