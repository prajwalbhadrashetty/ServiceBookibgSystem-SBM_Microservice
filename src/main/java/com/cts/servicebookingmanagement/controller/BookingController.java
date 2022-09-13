package com.cts.servicebookingmanagement.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cts.servicebookingmanagement.exception.InvalidTokenException;
import com.cts.servicebookingmanagement.feign.AuthClient;
import com.cts.servicebookingmanagement.model.AppServiceReq;
import com.cts.servicebookingmanagement.model.AppServiceReqReport;
import com.cts.servicebookingmanagement.model.ListResponse;
import com.cts.servicebookingmanagement.model.ListResponseReport;
import com.cts.servicebookingmanagement.model.Response;
import com.cts.servicebookingmanagement.model.ResponseReport;
import com.cts.servicebookingmanagement.service.BookingService;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class BookingController {

	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private AuthClient authClient;
	
    @PostMapping("/servicereq")
	public Response createBooking(@RequestHeader(name="authorization",required = true)String token, @RequestBody AppServiceReq appServiceReq)throws InvalidTokenException {
    	if (!authClient.verifyToken(token).isValid()) {
			throw new InvalidTokenException("Token is either expired or invalid");
		}
		AppServiceReq appServiceReq1=bookingService.createBooking(appServiceReq);
		Response response=new Response();
		if(!Objects.isNull(appServiceReq1)){
			response.setMessage("Successfully created the request. Your report id "+appServiceReq1.getId());
			response.setAppServiceReq(appServiceReq1);
			return response;
		}
		response.setMessage("Request id "+appServiceReq.getId()+ " is already available.");
		return response;
	}
	
	@GetMapping("/servicereq")
	public ListResponse getBooking(@RequestHeader(name="authorization",required = true)String token)throws InvalidTokenException{
		if (!authClient.verifyToken(token).isValid()) {
			throw new InvalidTokenException("Token is either expired or invalid");
		}
		List<AppServiceReq> reqs = bookingService.getBooking();
		ListResponse response=new ListResponse();
		if(reqs!=null) {
			response.setMessage("List of All requests :");
			response.setAppServiceReq(reqs);
		}else{
			response.setMessage("No request is available");
		}
		return response;
	}

	@PutMapping("/servicereq")
	public Response updateBooking(@RequestHeader(name="authorization",required = true)String token,@RequestBody AppServiceReq appServiceReq)throws InvalidTokenException {
		if (!authClient.verifyToken(token).isValid()) {
			throw new InvalidTokenException("Token is either expired or invalid");
		}
		AppServiceReq appServiceReq1 =  bookingService.updateBooking(appServiceReq);
		Response response=new Response();
		if(!Objects.isNull(appServiceReq1)){
			response.setMessage("Successfully Updated Details for request- id"+ appServiceReq1.getId());
			response.setAppServiceReq(appServiceReq1);
			return response;
		}
		response.setMessage("Id "+appServiceReq.getId()+" is not available");
		response.setAppServiceReq(null);
		return response;
	}
	
	@DeleteMapping("/servicereq/{id}")
	public String deleteUser(@RequestHeader(name="authorization",required = true)String token,@PathVariable Integer id)throws InvalidTokenException {
		if (!authClient.verifyToken(token).isValid()) {
			throw new InvalidTokenException("Token is either expired or invalid");
		}
		return bookingService.deleteBooking(id);
	}
	
	@GetMapping("/servicereq/id/{userid}")
	public ListResponse getUserById(@RequestHeader(name="authorization",required = true)String token, @PathVariable("userid") Integer userid)throws InvalidTokenException {
		if (!authClient.verifyToken(token).isValid()) {
			throw new InvalidTokenException("Token is either expired or invalid");
		}
		List<AppServiceReq> reqList = bookingService.getBookingById(userid);
		ListResponse response=new ListResponse();
		if(reqList!=null){
			response.setMessage("List of requests for user id "+userid);
			response.setAppServiceReq(reqList);
		}else {
			response.setMessage("No requests found for the user "+userid);
		}
		return response;
	}
	
	@GetMapping("/servicereq/{status}")
	public ListResponse getServiceByStatus(@RequestHeader(name="authorization",required = true)String token, @PathVariable("status") String status)throws InvalidTokenException {
		if (!authClient.verifyToken(token).isValid()) {
			throw new InvalidTokenException("Token is either expired or invalid");
		}
		List<AppServiceReq> reqList = bookingService.getServiceByStatus(status);
		ListResponse response=new ListResponse();
		if(reqList!=null){
			response.setMessage("List of requests for status "+status);
			response.setAppServiceReq(reqList);
		}else {
			response.setMessage("No requests found for the status "+status);
		}
		return response;
	}

	@PostMapping("/servicereq/report")
	public ResponseReport addReport(@RequestHeader(name="authorization",required = true)String token, @RequestBody AppServiceReqReport appServiceReqReport)throws InvalidTokenException {
		if (!authClient.verifyToken(token).isValid()) {
			throw new InvalidTokenException("Token is either expired or invalid");
		}
		AppServiceReqReport appServiceReqReport1 = bookingService.addReport(appServiceReqReport);
		ResponseReport response =new ResponseReport();
		if(!Objects.isNull(appServiceReqReport1)){
			response.setMessage("Successfully created the report. Your report id "+appServiceReqReport1.getReportId());
			response.setAppServiceReqReport(appServiceReqReport1);
			return response;
		}
		response.setMessage("Report id "+ appServiceReqReport.getReportId()+ " is already available.");
		return response;
	}

	@GetMapping("/servicereq/report")
	public ListResponseReport getAllBookingReport(@RequestHeader(name="authorization",required = true)String token)throws InvalidTokenException{
		if (!authClient.verifyToken(token).isValid()) {
			throw new InvalidTokenException("Token is either expired or invalid");
		}
		List<AppServiceReqReport> reqReports = bookingService.getAllBookingReport();
		ListResponseReport response=new ListResponseReport();
		if(reqReports!=null){
			response.setMessage("List of All reports :");
			response.setAppServiceReqReportList(reqReports);
		}else {
			response.setMessage("No Reports is unavailable");
		}
		return response;
	}

	@GetMapping("/servicereq/report/{reportId}")
	public ResponseReport getReportByreportId(@RequestHeader(name="authorization",required = true)String token,@PathVariable("reportId") Integer reportId)throws InvalidTokenException {
		if (!authClient.verifyToken(token).isValid()) {
			throw new InvalidTokenException("Token is either expired or invalid");
		}
		AppServiceReqReport appServiceReqReport= bookingService.getReportByreportId(reportId);
		ResponseReport response= new ResponseReport();
		if(appServiceReqReport!=null) {
			response.setMessage("List of All reports :");
			response.setAppServiceReqReport(appServiceReqReport);
		}else{
			response.setMessage("No report is available");
		}
		return response;
	}

	@DeleteMapping("/servicereq/report/{reportId}")
	public String deleteReport(@RequestHeader(name="authorization",required = true)String token,@PathVariable Integer reportId)throws InvalidTokenException {
		if (!authClient.verifyToken(token).isValid()) {
			throw new InvalidTokenException("Token is either expired or invalid");
		}
		return bookingService.deleteReport(reportId);
	}
	
}
