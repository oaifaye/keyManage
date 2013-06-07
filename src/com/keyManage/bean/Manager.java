package com.keyManage.bean;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

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
	private Set keyMessagesForCreateBy = new HashSet(0);
	private Set departmentsForCreateBy = new HashSet(0);
	private Set procedureVersionsForCreateBy = new HashSet(0);
	private Set keyAsksForUpdateBy = new HashSet(0);
	private Set kindOfKeiesForUpdateBy = new HashSet(0);
	private Set procedureVersionsForUpdateBy = new HashSet(0);
	private Set purposesForUpdateBy = new HashSet(0);
	private Set keyMessagesForUpdateBy = new HashSet(0);
	private Set departmentsForUpdateBy = new HashSet(0);
	private Set expressTypesForUpdateBy = new HashSet(0);
	private Set containsForCreateBy = new HashSet(0);
	private Set keyAsksForCreateBy = new HashSet(0);
	private Set purposesForCreateBy = new HashSet(0);
	private Set containsForUpdateBy = new HashSet(0);
	private Set kindOfKeiesForCreateBy = new HashSet(0);
	private Set procedureMessagesForCreateBy = new HashSet(0);
	private Set procedureMessagesForUpdateBy = new HashSet(0);
	private Set expressTypesForCreateBy = new HashSet(0);

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
			Timestamp createDate, String updateBy, Timestamp updateDate,
			Set keyMessagesForCreateBy, Set departmentsForCreateBy,
			Set procedureVersionsForCreateBy, Set keyAsksForUpdateBy,
			Set kindOfKeiesForUpdateBy, Set procedureVersionsForUpdateBy,
			Set purposesForUpdateBy, Set keyMessagesForUpdateBy,
			Set departmentsForUpdateBy, Set expressTypesForUpdateBy,
			Set containsForCreateBy, Set keyAsksForCreateBy,
			Set purposesForCreateBy, Set containsForUpdateBy,
			Set kindOfKeiesForCreateBy, Set procedureMessagesForCreateBy,
			Set procedureMessagesForUpdateBy, Set expressTypesForCreateBy) {
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
		this.keyMessagesForCreateBy = keyMessagesForCreateBy;
		this.departmentsForCreateBy = departmentsForCreateBy;
		this.procedureVersionsForCreateBy = procedureVersionsForCreateBy;
		this.keyAsksForUpdateBy = keyAsksForUpdateBy;
		this.kindOfKeiesForUpdateBy = kindOfKeiesForUpdateBy;
		this.procedureVersionsForUpdateBy = procedureVersionsForUpdateBy;
		this.purposesForUpdateBy = purposesForUpdateBy;
		this.keyMessagesForUpdateBy = keyMessagesForUpdateBy;
		this.departmentsForUpdateBy = departmentsForUpdateBy;
		this.expressTypesForUpdateBy = expressTypesForUpdateBy;
		this.containsForCreateBy = containsForCreateBy;
		this.keyAsksForCreateBy = keyAsksForCreateBy;
		this.purposesForCreateBy = purposesForCreateBy;
		this.containsForUpdateBy = containsForUpdateBy;
		this.kindOfKeiesForCreateBy = kindOfKeiesForCreateBy;
		this.procedureMessagesForCreateBy = procedureMessagesForCreateBy;
		this.procedureMessagesForUpdateBy = procedureMessagesForUpdateBy;
		this.expressTypesForCreateBy = expressTypesForCreateBy;
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

	public Set getKeyMessagesForCreateBy() {
		return this.keyMessagesForCreateBy;
	}

	public void setKeyMessagesForCreateBy(Set keyMessagesForCreateBy) {
		this.keyMessagesForCreateBy = keyMessagesForCreateBy;
	}

	public Set getDepartmentsForCreateBy() {
		return this.departmentsForCreateBy;
	}

	public void setDepartmentsForCreateBy(Set departmentsForCreateBy) {
		this.departmentsForCreateBy = departmentsForCreateBy;
	}

	public Set getProcedureVersionsForCreateBy() {
		return this.procedureVersionsForCreateBy;
	}

	public void setProcedureVersionsForCreateBy(Set procedureVersionsForCreateBy) {
		this.procedureVersionsForCreateBy = procedureVersionsForCreateBy;
	}

	public Set getKeyAsksForUpdateBy() {
		return this.keyAsksForUpdateBy;
	}

	public void setKeyAsksForUpdateBy(Set keyAsksForUpdateBy) {
		this.keyAsksForUpdateBy = keyAsksForUpdateBy;
	}

	public Set getKindOfKeiesForUpdateBy() {
		return this.kindOfKeiesForUpdateBy;
	}

	public void setKindOfKeiesForUpdateBy(Set kindOfKeiesForUpdateBy) {
		this.kindOfKeiesForUpdateBy = kindOfKeiesForUpdateBy;
	}

	public Set getProcedureVersionsForUpdateBy() {
		return this.procedureVersionsForUpdateBy;
	}

	public void setProcedureVersionsForUpdateBy(Set procedureVersionsForUpdateBy) {
		this.procedureVersionsForUpdateBy = procedureVersionsForUpdateBy;
	}

	public Set getPurposesForUpdateBy() {
		return this.purposesForUpdateBy;
	}

	public void setPurposesForUpdateBy(Set purposesForUpdateBy) {
		this.purposesForUpdateBy = purposesForUpdateBy;
	}

	public Set getKeyMessagesForUpdateBy() {
		return this.keyMessagesForUpdateBy;
	}

	public void setKeyMessagesForUpdateBy(Set keyMessagesForUpdateBy) {
		this.keyMessagesForUpdateBy = keyMessagesForUpdateBy;
	}

	public Set getDepartmentsForUpdateBy() {
		return this.departmentsForUpdateBy;
	}

	public void setDepartmentsForUpdateBy(Set departmentsForUpdateBy) {
		this.departmentsForUpdateBy = departmentsForUpdateBy;
	}

	public Set getExpressTypesForUpdateBy() {
		return this.expressTypesForUpdateBy;
	}

	public void setExpressTypesForUpdateBy(Set expressTypesForUpdateBy) {
		this.expressTypesForUpdateBy = expressTypesForUpdateBy;
	}

	public Set getContainsForCreateBy() {
		return this.containsForCreateBy;
	}

	public void setContainsForCreateBy(Set containsForCreateBy) {
		this.containsForCreateBy = containsForCreateBy;
	}

	public Set getKeyAsksForCreateBy() {
		return this.keyAsksForCreateBy;
	}

	public void setKeyAsksForCreateBy(Set keyAsksForCreateBy) {
		this.keyAsksForCreateBy = keyAsksForCreateBy;
	}

	public Set getPurposesForCreateBy() {
		return this.purposesForCreateBy;
	}

	public void setPurposesForCreateBy(Set purposesForCreateBy) {
		this.purposesForCreateBy = purposesForCreateBy;
	}

	public Set getContainsForUpdateBy() {
		return this.containsForUpdateBy;
	}

	public void setContainsForUpdateBy(Set containsForUpdateBy) {
		this.containsForUpdateBy = containsForUpdateBy;
	}

	public Set getKindOfKeiesForCreateBy() {
		return this.kindOfKeiesForCreateBy;
	}

	public void setKindOfKeiesForCreateBy(Set kindOfKeiesForCreateBy) {
		this.kindOfKeiesForCreateBy = kindOfKeiesForCreateBy;
	}

	public Set getProcedureMessagesForCreateBy() {
		return this.procedureMessagesForCreateBy;
	}

	public void setProcedureMessagesForCreateBy(Set procedureMessagesForCreateBy) {
		this.procedureMessagesForCreateBy = procedureMessagesForCreateBy;
	}

	public Set getProcedureMessagesForUpdateBy() {
		return this.procedureMessagesForUpdateBy;
	}

	public void setProcedureMessagesForUpdateBy(Set procedureMessagesForUpdateBy) {
		this.procedureMessagesForUpdateBy = procedureMessagesForUpdateBy;
	}

	public Set getExpressTypesForCreateBy() {
		return this.expressTypesForCreateBy;
	}

	public void setExpressTypesForCreateBy(Set expressTypesForCreateBy) {
		this.expressTypesForCreateBy = expressTypesForCreateBy;
	}

}