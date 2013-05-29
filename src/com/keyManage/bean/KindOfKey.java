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
	private Manager managerByUpdateBy;
	private KindOfKey kindOfKey;
	private Manager managerByCreateBy;
	private String kindName;
	private String remark;
	private String isDelete;
	private Timestamp createDate;
	private Timestamp updateDate;
	private Set contains = new HashSet(0);
	private Set keyMessages = new HashSet(0);
	private Set keyAsks = new HashSet(0);
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
	public KindOfKey(String id, Manager managerByUpdateBy, KindOfKey kindOfKey,
			Manager managerByCreateBy, String kindName, String remark,
			String isDelete, Timestamp createDate, Timestamp updateDate,
			Set contains, Set keyMessages, Set keyAsks, Set kindOfKeies) {
		this.id = id;
		this.managerByUpdateBy = managerByUpdateBy;
		this.kindOfKey = kindOfKey;
		this.managerByCreateBy = managerByCreateBy;
		this.kindName = kindName;
		this.remark = remark;
		this.isDelete = isDelete;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.contains = contains;
		this.keyMessages = keyMessages;
		this.keyAsks = keyAsks;
		this.kindOfKeies = kindOfKeies;
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

	public KindOfKey getKindOfKey() {
		return this.kindOfKey;
	}

	public void setKindOfKey(KindOfKey kindOfKey) {
		this.kindOfKey = kindOfKey;
	}

	public Manager getManagerByCreateBy() {
		return this.managerByCreateBy;
	}

	public void setManagerByCreateBy(Manager managerByCreateBy) {
		this.managerByCreateBy = managerByCreateBy;
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

	public Set getContains() {
		return this.contains;
	}

	public void setContains(Set contains) {
		this.contains = contains;
	}

	public Set getKeyMessages() {
		return this.keyMessages;
	}

	public void setKeyMessages(Set keyMessages) {
		this.keyMessages = keyMessages;
	}

	public Set getKeyAsks() {
		return this.keyAsks;
	}

	public void setKeyAsks(Set keyAsks) {
		this.keyAsks = keyAsks;
	}

	public Set getKindOfKeies() {
		return this.kindOfKeies;
	}

	public void setKindOfKeies(Set kindOfKeies) {
		this.kindOfKeies = kindOfKeies;
	}

}