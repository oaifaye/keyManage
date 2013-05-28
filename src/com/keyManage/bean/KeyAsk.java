package com.keyManage.bean;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * KeyAsk entity. @author MyEclipse Persistence Tools
 */

public class KeyAsk implements java.io.Serializable {

	// Fields

	private String id;
	private KindOfKey kindOfKey;
	private Manager managerByUpdateBy;
	private Manager managerByCreateBy;
	private Timestamp askDate;
	private Timestamp answerDate;
	private Integer askNum;
	private String askRemark;
	private String isFinished;
	private String isDelete;
	private Timestamp createDate;
	private Timestamp updateDate;
	private Set contains = new HashSet(0);
	//此属性不参与数据库
	private Integer lastNum;

	// Constructors

	/** default constructor */
	public KeyAsk() {
	}

	/** minimal constructor */
	public KeyAsk(String id) {
		this.id = id;
	}

	/** full constructor */
	public KeyAsk(String id, KindOfKey kindOfKey, Manager managerByUpdateBy,
			Manager managerByCreateBy, Timestamp askDate, Timestamp answerDate,
			Integer askNum, String askRemark, String isFinished,
			String isDelete, Timestamp createDate, Timestamp updateDate,
			Set contains) {
		this.id = id;
		this.kindOfKey = kindOfKey;
		this.managerByUpdateBy = managerByUpdateBy;
		this.managerByCreateBy = managerByCreateBy;
		this.askDate = askDate;
		this.answerDate = answerDate;
		this.askNum = askNum;
		this.askRemark = askRemark;
		this.isFinished = isFinished;
		this.isDelete = isDelete;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.contains = contains;
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

	public Manager getManagerByCreateBy() {
		return this.managerByCreateBy;
	}

	public void setManagerByCreateBy(Manager managerByCreateBy) {
		this.managerByCreateBy = managerByCreateBy;
	}

	public Timestamp getAskDate() {
		return this.askDate;
	}

	public void setAskDate(Timestamp askDate) {
		this.askDate = askDate;
	}

	public Timestamp getAnswerDate() {
		return this.answerDate;
	}

	public void setAnswerDate(Timestamp answerDate) {
		this.answerDate = answerDate;
	}

	public Integer getAskNum() {
		return this.askNum;
	}

	public void setAskNum(Integer askNum) {
		this.askNum = askNum;
	}

	public String getAskRemark() {
		return this.askRemark;
	}

	public void setAskRemark(String askRemark) {
		this.askRemark = askRemark;
	}

	public String getIsFinished() {
		return this.isFinished;
	}

	public void setIsFinished(String isFinished) {
		this.isFinished = isFinished;
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
	public Integer getLastNum() {
		return lastNum;
	}

	public void setLastNum(Integer lastNum) {
		this.lastNum = lastNum;
	}

}