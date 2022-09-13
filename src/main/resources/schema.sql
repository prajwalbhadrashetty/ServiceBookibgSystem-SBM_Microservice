/*
 *private Integer reportId;
	private Integer serReqId;
	private Date reportDate;
	private String serviceType; // (general, repair, support),
	private String actionTaken;
	private String diagnosisDetails;
	private String isPaid;
	private String visitFees;
	private String repairDetails;
 */

create table APP_SERVICE_REQ (id int Auto_increment, productId int, userId int,req_Date Date, problem varchar(255),description varchar(255), status varchar(255));
create table APP_SERVICE_REQ_REPORT (id int Auto_increment, ser_Req_Id int,report_Date Date, service_Type varchar(255),action_Taken varchar(255), diagnosis_Details varchar(255), isPaid varchar(255),visit_Details varchar(255),repair_Details varchar(255));

CREATE SEQUENCE HIBERNATE_SEQUENCE START WITH 1 INCREMENT BY 1;
