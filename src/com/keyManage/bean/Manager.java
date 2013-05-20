package com.keyManage.bean;

import java.sql.Timestamp;

/**
 * Manager entity. @author MyEclipse Persistence Tools
 */

public class Manager implements java.io.Serializable {

	// Fields

	private String id;
	private String name;
	private String userName;
	private String password;
	private String role;
	private String isDelete;
	private String createBy;
	private Timestamp createDate;
	private String updateBy;
	private Timestamp updateDate;

	// Constructors

	/** default constructor */
	public Manager() {
	}

	/** minimal constructor */
	public Manager(String id) {
		this.id = id;
	}

	/** full constructor */
	public Manager(String id, String name, String userName, String password,
			String role, String isDelete, String createBy,
			Timestamp createDate, String updateBy, Timestamp updateDate) {
		this.id = id;
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.isDelete = isDelete;
		this.createBy = createBy;
		this.createDate = createDate;
		this.updateBy = updateBy;
		this.updateDate = updateDate;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
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

}