package com.keyManage.bean;

import java.sql.Timestamp;

/**
 * Key entity. @author MyEclipse Persistence Tools
 */

public class Key implements java.io.Serializable {

	// Fields

	private String id;
	private KindOfKey kindOfKey;
	private Version version;
	private Manager managerByUpdateBy;
	private LotNumber lotNumber;
	private Department department;
	private ExpressType expressType;
	private Manager managerByCreateBy;
	private String userName;
	private String expressCode;
	private String postCode;
	private Timestamp expressDate;
	private String isDelete;
	private Timestamp createDate;
	private Timestamp updateDate;

	// Constructors

	/** default constructor */
	public Key() {
	}

	/** minimal constructor */
	public Key(String id) {
		this.id = id;
	}

	/** full constructor */
	public Key(String id, KindOfKey kindOfKey, Version version,
			Manager managerByUpdateBy, LotNumber lotNumber,
			Department department, ExpressType expressType,
			Manager managerByCreateBy, String userName, String expressCode,
			String postCode, Timestamp expressDate, String isDelete,
			Timestamp createDate, Timestamp updateDate) {
		this.id = id;
		this.kindOfKey = kindOfKey;
		this.version = version;
		this.managerByUpdateBy = managerByUpdateBy;
		this.lotNumber = lotNumber;
		this.department = department;
		this.expressType = expressType;
		this.managerByCreateBy = managerByCreateBy;
		this.userName = userName;
		this.expressCode = expressCode;
		this.postCode = postCode;
		this.expressDate = expressDate;
		this.isDelete = isDelete;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public KindOfKey getKindOfKey() {
		return this.kindOfKey;
	}

	public void setKindOfKey(KindOfKey kindOfKey) {
		this.kindOfKey = kindOfKey;
	}

	public Version getVersion() {
		return this.version;
	}

	public void setVersion(Version version) {
		this.version = version;
	}

	public Manager getManagerByUpdateBy() {
		return this.managerByUpdateBy;
	}

	public void setManagerByUpdateBy(Manager managerByUpdateBy) {
		this.managerByUpdateBy = managerByUpdateBy;
	}

	public LotNumber getLotNumber() {
		return this.lotNumber;
	}

	public void setLotNumber(LotNumber lotNumber) {
		this.lotNumber = lotNumber;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public ExpressType getExpressType() {
		return this.expressType;
	}

	public void setExpressType(ExpressType expressType) {
		this.expressType = expressType;
	}

	public Manager getManagerByCreateBy() {
		return this.managerByCreateBy;
	}

	public void setManagerByCreateBy(Manager managerByCreateBy) {
		this.managerByCreateBy = managerByCreateBy;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getExpressCode() {
		return this.expressCode;
	}

	public void setExpressCode(String expressCode) {
		this.expressCode = expressCode;
	}

	public String getPostCode() {
		return this.postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public Timestamp getExpressDate() {
		return this.expressDate;
	}

	public void setExpressDate(Timestamp expressDate) {
		this.expressDate = expressDate;
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

}