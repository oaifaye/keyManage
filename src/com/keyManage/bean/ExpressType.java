package com.keyManage.bean;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * ExpressType entity. @author MyEclipse Persistence Tools
 */

public class ExpressType implements java.io.Serializable {

	// Fields

	private String id;
	private Manager managerByUpdateBy;
	private Manager managerByCreateBy;
	private String expressTypeName;
	private String isDelete;
	private Timestamp createDate;
	private Timestamp updateDate;
	private Set keyMessages = new HashSet(0);

	// Constructors

	/** default constructor */
	public ExpressType() {
	}

	/** minimal constructor */
	public ExpressType(String id) {
		this.id = id;
	}

	/** full constructor */
	public ExpressType(String id, Manager managerByUpdateBy,
			Manager managerByCreateBy, String expressTypeName, String isDelete,
			Timestamp createDate, Timestamp updateDate, Set keyMessages) {
		this.id = id;
		this.managerByUpdateBy = managerByUpdateBy;
		this.managerByCreateBy = managerByCreateBy;
		this.expressTypeName = expressTypeName;
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

	public Manager getManagerByCreateBy() {
		return this.managerByCreateBy;
	}

	public void setManagerByCreateBy(Manager managerByCreateBy) {
		this.managerByCreateBy = managerByCreateBy;
	}

	public String getExpressTypeName() {
		return this.expressTypeName;
	}

	public void setExpressTypeName(String expressTypeName) {
		this.expressTypeName = expressTypeName;
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