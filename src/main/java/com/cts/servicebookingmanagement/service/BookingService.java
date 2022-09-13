package com.cts.servicebookingmanagement.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.servicebookingmanagement.dao.BookingDao;
import com.cts.servicebookingmanagement.dao.BookingDaoReq;
import com.cts.servicebookingmanagement.model.AppServiceReq;
import com.cts.servicebookingmanagement.model.AppServiceReqReport;

@Service
public class BookingService {

	@Autowired
	private BookingDao bookingDao;
	
	@Autowired
	private BookingDaoReq bookingDaoReq;
	
	public AppServiceReq createBooking(AppServiceReq appServiceReq) {
		return bookingDao.save(appServiceReq);
	}
	
	public List<AppServiceReq> getBooking(){
		return (List<AppServiceReq>) bookingDao.findAll();
	}
	
	
	public AppServiceReq updateBooking(AppServiceReq appServiceReq) {
		Integer id = appServiceReq.getId();
		AppServiceReq book = bookingDao.findById(id).orElse(null);
		if(!Objects.isNull(book)) {
			book.setReqDate(appServiceReq.getReqDate());
			book.setProblem(appServiceReq.getProblem());
			book.setDescription(appServiceReq.getDescription());
			book.setStatus(appServiceReq.getStatus());
			return bookingDao.save(book);
		}
		return null;
	}
	
	public String deleteBooking(Integer id) {
		bookingDao.deleteById(id);
		return "User "+id+" is successfully deleted";
	}
	
	public List<AppServiceReq> getBookingById(Integer userid) {
		return bookingDao.findAllByUserId(userid).orElse(null);
	}

	public List<AppServiceReq> getServiceByStatus(String status) {
		return bookingDao.findAllByStatus(status).orElse(null);
	}

	public List<AppServiceReqReport> getAllBookingReport() {
		return (List<AppServiceReqReport>) bookingDaoReq.findAll();	
	}

	public AppServiceReq getReportById(Integer userid) {
		return bookingDao.findById(userid).orElse(null);
	}

	public AppServiceReqReport getReportByreportId(Integer reportId) {
		return bookingDaoReq.findById(reportId).orElse(null);
	}

	public AppServiceReqReport addReport(AppServiceReqReport appServiceReqReport) {
		return bookingDaoReq.save(appServiceReqReport);
	}
	
	public String deleteReport(Integer reportId) {
		bookingDaoReq.deleteById(reportId);
		return "User "+reportId+" is successfully deleted";
	}
}

