package com.keyManage.bean;

import java.sql.Timestamp;

/**
 * Contain entity. @author MyEclipse Persistence Tools
 */

public class Contain implements java.io.Serializable {

	// Fields

	private String id;
	private KindOfKey kindOfKey;
	private Manager managerByUpdateBy;
	private KeyAsk keyAsk;
	private Manager managerByCreateBy;
	private String lotNumber;
	private Timestamp containDate;
	private Integer keyNum;
	private String saveOrTake;
	private String isDelete;
	private Timestamp createDate;
	private Timestamp updateDate;

	// Constructors

	/** default constructor */
	public Contain() {
	}

	/** minimal constructor */
	public Contain(String id) {
		this.id = id;
	}

	/** full constructor */
	public Contain(String id, KindOfKey kindOfKey, Manager managerByUpdateBy,
			KeyAsk keyAsk, Manager managerByCreateBy, String lotNumber,
			Timestamp containDate, Integer keyNum, String saveOrTake,
			String isDelete, Timestamp createDate, Timestamp updateDate) {
		this.id = id;
		this.kindOfKey = kindOfKey;
		this.managerByUpdateBy = managerByUpdateBy;
		this.keyAsk = keyAsk;
		this.managerByCreateBy = managerByCreateBy;
		this.lotNumber = lotNumber;
		this.containDate = containDate;
		this.keyNum = keyNum;
		this.saveOrTake = saveOrTake;
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

	public KeyAsk getKeyAsk() {
		return this.keyAsk;
	}

	public void setKeyAsk(KeyAsk keyAsk) {
		this.keyAsk = keyAsk;
	}

	public Manager getManagerByCreateBy() {
		return this.managerByCreateBy;
	}

	public void setManagerByCreateBy(Manager managerByCreateBy) {
		this.managerByCreateBy = managerByCreateBy;
	}

	public String getLotNumber() {
		return this.lotNumber;
	}

	public void setLotNumber(String lotNumber) {
		this.lotNumber = lotNumber;
	}

	public Timestamp getContainDate() {
		return this.containDate;
	}

	public void setContainDate(Timestamp containDate) {
		this.containDate = containDate;
	}

	public Integer getKeyNum() {
		return this.keyNum;
	}

	public void setKeyNum(Integer keyNum) {
		this.keyNum = keyNum;
	}

	public String getSaveOrTake() {
		return this.saveOrTake;
	}

	public void setSaveOrTake(String saveOrTake) {
		this.saveOrTake = saveOrTake;
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