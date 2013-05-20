package com.keyManage.bean;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Procedure entity. @author MyEclipse Persistence Tools
 */

public class Procedure implements java.io.Serializable {

	// Fields

	private String id;
	private String procedureName;
	private String isDelete;
	private String createBy;
	private Timestamp createDate;
	private String updateBy;
	private Timestamp updateDate;
	private Set versions = new HashSet(0);

	// Constructors

	/** default constructor */
	public Procedure() {
	}

	/** minimal constructor */
	public Procedure(String id) {
		this.id = id;
	}

	/** full constructor */
	public Procedure(String id, String procedureName, String isDelete,
			String createBy, Timestamp createDate, String updateBy,
			Timestamp updateDate, Set versions) {
		this.id = id;
		this.procedureName = procedureName;
		this.isDelete = isDelete;
		this.createBy = createBy;
		this.createDate = createDate;
		this.updateBy = updateBy;
		this.updateDate = updateDate;
		this.versions = versions;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProcedureName() {
		return this.procedureName;
	}

	public void setProcedureName(String procedureName) {
		this.procedureName = procedureName;
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

	public Set getVersions() {
		return this.versions;
	}

	public void setVersions(Set versions) {
		this.versions = versions;
	}

}