package com.cts.servicebookingmanagement.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cts.servicebookingmanagement.model.AppServiceReqReport;

@Repository
public interface BookingDaoReq extends CrudRepository<AppServiceReqReport, Integer> {

}
