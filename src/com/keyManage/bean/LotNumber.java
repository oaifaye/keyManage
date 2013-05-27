package com.keyManage.bean;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * LotNumber entity. @author MyEclipse Persistence Tools
 */

public class LotNumber implements java.io.Serializable {

	// Fields

	private String id;
	private String lotNumberName;
	private Timestamp deliveryDate;
	private String isDelete;
	private String createBy;
	private Timestamp createDate;
	private String updateBy;
	private Timestamp updateDate;
	private Set keies = new HashSet(0);

	// Constructors

	/** default constructor */
	public LotNumber() {
	}

	/** minimal constructor */
	public LotNumber(String id) {
		this.id = id;
	}

	/** full constructor */
	public LotNumber(String id, String lotNumberName, Timestamp deliveryDate,
			String isDelete, String createBy, Timestamp createDate,
			String updateBy, Timestamp updateDate, Set keies) {
		this.id = id;
		this.lotNumberName = lotNumberName;
		this.deliveryDate = deliveryDate;
		this.isDelete = isDelete;
		this.createBy = createBy;
		this.createDate = createDate;
		this.updateBy = updateBy;
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

	public String getLotNumberName() {
		return this.lotNumberName;
	}

	public void setLotNumberName(String lotNumberName) {
		this.lotNumberName = lotNumberName;
	}

	public Timestamp getDeliveryDate() {
		return this.deliveryDate;
	}

	public void setDeliveryDate(Timestamp deliveryDate) {
		this.deliveryDate = deliveryDate;
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

	public Set getKeies() {
		return this.keies;
	}

	public void setKeies(Set keies) {
		this.keies = keies;
	}

}