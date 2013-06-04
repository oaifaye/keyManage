package com.keyManage.util;

import java.sql.Timestamp;

public class SelectObject {
	private String procedureMessage;
	private String department;
	private String purpose;
	private String startDate;
	private String endDate;
	private String createBy;
	public String getProcedureMessage() {
		return procedureMessage;
	}
	public void setProcedureMessage(String procedureMessage) {
		this.procedureMessage = procedureMessage;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	
}
