package com.keyManage.bean;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * KindOfKey entity. @author MyEclipse Persistence Tools
 */

public class KindOfKey implements java.io.Serializable {

	// Fields

	private String id;
	private KindOfKey kindOfKey;
	private String kindName;
	private String remark;
	private String isDelete;
	private String createBy;
	private Timestamp createDate;
	private String updateBy;
	private Timestamp updateDate;
	private Set keies = new HashSet(0);
	private Set kindOfKeies = new HashSet(0);

	// Constructors

	/** default constructor */
	public KindOfKey() {
	}

	/** minimal constructor */
	public KindOfKey(String id, KindOfKey kindOfKey) {
		this.id = id;
		this.kindOfKey = kindOfKey;
	}

	/** full constructor */
	public KindOfKey(String id, KindOfKey kindOfKey, String kindName,
			String remark, String isDelete, String createBy,
			Timestamp createDate, String updateBy, Timestamp updateDate,
			Set keies, Set kindOfKeies) {
		this.id = id;
		this.kindOfKey = kindOfKey;
		this.kindName = kindName;
		this.remark = remark;
		this.isDelete = isDelete;
		this.createBy = createBy;
		this.createDate = createDate;
		this.updateBy = updateBy;
		this.updateDate = updateDate;
		this.keies = keies;
		this.kindOfKeies = kindOfKeies;
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

	public String getKindName() {
		return this.kindName;
	}

	public void setKindName(String kindName) {
		this.kindName = kindName;
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

	public Set getKindOfKeies() {
		return this.kindOfKeies;
	}

	public void setKindOfKeies(Set kindOfKeies) {
		this.kindOfKeies = kindOfKeies;
	}

}