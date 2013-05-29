package com.keyManage.bean;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Version entity. @author MyEclipse Persistence Tools
 */

public class Version implements java.io.Serializable {

	// Fields

	private String id;
	private Procedure procedure;
	private String versionName;
	private String isDelete;
	private String createBy;
	private Timestamp createDate;
	private String updateBy;
	private Timestamp updateDate;
	private Set keyMessages = new HashSet(0);

	// Constructors

	/** default constructor */
	public Version() {
	}

	/** minimal constructor */
	public Version(String id) {
		this.id = id;
	}

	/** full constructor */
	public Version(String id, Procedure procedure, String versionName,
			String isDelete, String createBy, Timestamp createDate,
			String updateBy, Timestamp updateDate, Set keyMessages) {
		this.id = id;
		this.procedure = procedure;
		this.versionName = versionName;
		this.isDelete = isDelete;
		this.createBy = createBy;
		this.createDate = createDate;
		this.updateBy = updateBy;
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

	public Procedure getProcedure() {
		return this.procedure;
	}

	public void setProcedure(Procedure procedure) {
		this.procedure = procedure;
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

	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getUpdateBy() {
		return this.updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
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