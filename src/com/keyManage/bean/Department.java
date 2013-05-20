package com.keyManage.bean;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Department entity. @author MyEclipse Persistence Tools
 */

public class Department implements java.io.Serializable {

	// Fields

	private String id;
	private Province province;
	private Manager managerByUpdateBy;
	private Manager managerByCreateBy;
	private String departmentName;
	private String departmentCode;
	private String isDelete;
	private Timestamp createDate;
	private Timestamp updateDate;
	private Set keies = new HashSet(0);

	// Constructors

	/** default constructor */
	public Department() {
	}

	/** minimal constructor */
	public Department(String id) {
		this.id = id;
	}

	/** full constructor */
	public Department(String id, Province province, Manager managerByUpdateBy,
			Manager managerByCreateBy, String departmentName,
			String departmentCode, String isDelete, Timestamp createDate,
			Timestamp updateDate, Set keies) {
		this.id = id;
		this.province = province;
		this.managerByUpdateBy = managerByUpdateBy;
		this.managerByCreateBy = managerByCreateBy;
		this.departmentName = departmentName;
		this.departmentCode = departmentCode;
		this.isDelete = isDelete;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.keies = keies;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Province getProvince() {
		return this.province;
	}

	public void setProvince(Province province) {
		this.province = province;
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

	public String getDepartmentName() {
		return this.departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentCode() {
		return this.departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
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

	public Set getKeies() {
		return this.keies;
	}

	public void setKeies(Set keies) {
		this.keies = keies;
	}

}