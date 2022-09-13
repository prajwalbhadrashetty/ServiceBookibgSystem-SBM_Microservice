package com.cts.servicebookingmanagement.model;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
public class AppServiceReq {


	@Id
	@GeneratedValue
	private Integer id;
	private Integer productId;
	private Integer userId;
	private LocalDate reqDate;
	private String problem; 
	private String description; 
	private String status  ;

	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDate getReqDate() {
		return reqDate;
	}
	public void setReqDate(LocalDate reqDate) {
		this.reqDate = reqDate;
	}

		
	
}
