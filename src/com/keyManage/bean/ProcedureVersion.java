package com.keyManage.bean;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * ProcedureVersion entity. @author MyEclipse Persistence Tools
 */

public class ProcedureVersion implements java.io.Serializable {

	// Fields

	private String id;
	private Manager managerByUpdateBy;
	private ProcedureMessage procedureMessage;
	private Manager managerByCreateBy;
	private String versionName;
	private String isDelete;
	private Timestamp createDate;
	private Timestamp updateDate;
	private Set keyMessages = new HashSet(0);

	// Constructors

	/** default constructor */
	public ProcedureVersion() {
	}

	/** minimal constructor */
	public ProcedureVersion(String id) {
		this.id = id;
	}

	/** full constructor */
	public ProcedureVersion(String id, Manager managerByUpdateBy,
			ProcedureMessage procedureMessage, Manager managerByCreateBy,
			String versionName, String isDelete, Timestamp createDate,
			Timestamp updateDate, Set keyMessages) {
		this.id = id;
		this.managerByUpdateBy = managerByUpdateBy;
		this.procedureMessage = procedureMessage;
		this.managerByCreateBy = managerByCreateBy;
		this.versionName = versionName;
		this.isDelete = isDelete;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.keyMessages = keyMessages;
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

	public ProcedureMessage getProcedureMessage() {
		return this.procedureMessage;
	}

	public void setProcedureMessage(ProcedureMessage procedureMessage) {
		this.procedureMessage = procedureMessage;
	}

	public Manager getManagerByCreateBy() {
		return this.managerByCreateBy;
	}

	public void setManagerByCreateBy(Manager managerByCreateBy) {
		this.managerByCreateBy = managerByCreateBy;
	}

	public String getVersionName() {
		return this.versionName;
	}

	public void setVersionName(String versionName) {
		this.versionName = versionName;
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

}