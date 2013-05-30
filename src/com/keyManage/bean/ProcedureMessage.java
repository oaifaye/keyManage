package com.keyManage.bean;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * ProcedureMessage entity. @author MyEclipse Persistence Tools
 */

public class ProcedureMessage implements java.io.Serializable {

	// Fields

	private String id;
	private Manager managerByUpdateBy;
	private Manager managerByCreateBy;
	private String procedureName;
	private String remark;
	private String isDelete;
	private Timestamp createDate;
	private Timestamp updateDate;
	private Set keyMessages = new HashSet(0);
	private Set procedureVersions = new HashSet(0);

	// Constructors

	/** default constructor */
	public ProcedureMessage() {
	}

	/** minimal constructor */
	public ProcedureMessage(String id) {
		this.id = id;
	}

	/** full constructor */
	public ProcedureMessage(String id, Manager managerByUpdateBy,
			Manager managerByCreateBy, String procedureName, String remark,
			String isDelete, Timestamp createDate, Timestamp updateDate,
			Set keyMessages, Set procedureVersions) {
		this.id = id;
		this.managerByUpdateBy = managerByUpdateBy;
		this.managerByCreateBy = managerByCreateBy;
		this.procedureName = procedureName;
		this.remark = remark;
		this.isDelete = isDelete;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.keyMessages = keyMessages;
		this.procedureVersions = procedureVersions;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Manager getManagerByUpdateBy() {
		return this.managerByUpdateBy;
	}

	public void setManagerByUpdateBy(Manager managerByUpdateBy) {
		this.managerByUpdateBy = managerByUpdateBy;
	}

	public Manager getManagerByCreateBy() {
		return this.managerByCreateBy;
	}

	public void setManagerByCreateBy(Manager managerByCreateBy) {
		this.managerByCreateBy = managerByCreateBy;
	}

	public String getProcedureName() {
		return this.procedureName;
	}

	public void setProcedureName(String procedureName) {
		this.procedureName = procedureName;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public Set getKeyMessages() {
		return this.keyMessages;
	}

	public void setKeyMessages(Set keyMessages) {
		this.keyMessages = keyMessages;
	}

	public Set getProcedureVersions() {
		return this.procedureVersions;
	}

	public void setProcedureVersions(Set procedureVersions) {
		this.procedureVersions = procedureVersions;
	}

}