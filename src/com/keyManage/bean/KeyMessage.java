package com.keyManage.bean;

import java.sql.Timestamp;

/**
 * KeyMessage entity. @author MyEclipse Persistence Tools
 */

public class KeyMessage implements java.io.Serializable {

	// Fields

	private String id;
	private KindOfKey kindOfKey;
	private Manager managerByUpdateBy;
	private ProcedureMessage procedureMessage;
	private Department department;
	private ProcedureVersion procedureVersion;
	private ExpressType expressType;
	private Manager managerByCreateBy;
	private Contain contain;
	private String userName;
	private Integer keyNum;
	private String purposeId;
	private String expressCode;
	private String postCode;
	private Timestamp expressDate;
	private String remark;
	private String isDelete;
	private Timestamp createDate;
	private Timestamp updateDate;

	// Constructors

	/** default constructor */
	public KeyMessage() {
	}

	/** minimal constructor */
	public KeyMessage(String id) {
		this.id = id;
	}

	/** full constructor */
	public KeyMessage(String id, KindOfKey kindOfKey,
			Manager managerByUpdateBy, ProcedureMessage procedureMessage,
			Department department, ProcedureVersion procedureVersion,
			ExpressType expressType, Manager managerByCreateBy,
			Contain contain, String userName, Integer keyNum, String purposeId,
			String expressCode, String postCode, Timestamp expressDate,
			String remark, String isDelete, Timestamp createDate,
			Timestamp updateDate) {
		this.id = id;
		this.kindOfKey = kindOfKey;
		this.managerByUpdateBy = managerByUpdateBy;
		this.procedureMessage = procedureMessage;
		this.department = department;
		this.procedureVersion = procedureVersion;
		this.expressType = expressType;
		this.managerByCreateBy = managerByCreateBy;
		this.contain = contain;
		this.userName = userName;
		this.keyNum = keyNum;
		this.purposeId = purposeId;
		this.expressCode = expressCode;
		this.postCode = postCode;
		this.expressDate = expressDate;
		this.remark = remark;
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

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public ProcedureVersion getProcedureVersion() {
		return this.procedureVersion;
	}

	public void setProcedureVersion(ProcedureVersion procedureVersion) {
		this.procedureVersion = procedureVersion;
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

	public Contain getContain() {
		return this.contain;
	}

	public void setContain(Contain contain) {
		this.contain = contain;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getKeyNum() {
		return this.keyNum;
	}

	public void setKeyNum(Integer keyNum) {
		this.keyNum = keyNum;
	}

	public String getPurposeId() {
		return this.purposeId;
	}

	public void setPurposeId(String purposeId) {
		this.purposeId = purposeId;
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

}