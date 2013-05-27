package com.keyManage.action;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.keyManage.bean.KeyAsk;
import com.keyManage.bean.KindOfKey;
import com.keyManage.bean.Manager;
import com.keyManage.service.contain.ContainService;
import com.keyManage.service.keyAsk.KeyAskService;
import com.keyManage.service.kindOfKey.KindOfKeyService;
import com.keyManage.util.CountObject;
import com.keyManage.util.TimeSupport;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class KeyAskAction extends ActionSupport {
	private KeyAskService keyAskService;
	private ContainService containService;
	private KindOfKeyService kindOfKeyService;
	private List<CountObject> countObjectList;//含有各种锁的剩余数量的对象
	private List<KeyAsk> keyAskList;
	private KeyAsk keyAsk;
	private KindOfKey kindOfKey;
	private String askDate;

	//==============================================锁申请用户===========================================================
	//初始化keyAsk.jsp
	public String initKeyAsk(){
		try {
			countObjectList = containService.findLastKey();
			return "initKeyAsk";
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	//保存锁申请
	public String addKeyAsk(){
		try {
			if(!kindOfKey.getId().equals("")&&kindOfKey.getId()!=null){
			//kindOfKey=kindOfKeyService.findByPrimaryKey(kindOfKey.getId());
			//KindOfKey kindOfKey = new KindOfKey();
			//kindOfKey.setId(kindOfKeyId);
				keyAsk.setKindOfKey(kindOfKey);
				keyAsk.setAskDate(TimeSupport.parseTime(askDate, "yyyy-MM-dd"));
				keyAsk.setIsFinished("1");
				keyAsk.setIsDelete("1");
				Manager manager = (Manager)ActionContext.getContext().getSession().get("manager");
				keyAsk.setManagerByCreateBy(manager);
				keyAsk.setCreateDate(new Timestamp(System.currentTimeMillis()));
				keyAskService.addKeyAsk(keyAsk);
			}
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	//初始化listKeyAsk.jsp
	public String initListKeyAsk(){
		try {
			Map<String, Object> params= new HashMap<String, Object>();
			Manager manager = (Manager)ActionContext.getContext().getSession().get("manager");
			params.put("isDelete", "1");
			params.put("managerByCreateBy.id", manager.getId());
			keyAskList=keyAskService.findListByParams(params);
			return "initListKeyAsk";
		} catch (Exception e) {
			return ERROR;
		}
		
	}
	
	//==========================================================================================================
	public KeyAskService getKeyAskService() {
		return keyAskService;
	}

	public void setKeyAskService(KeyAskService keyAskService) {
		this.keyAskService = keyAskService;
	}

	public ContainService getContainService() {
		return containService;
	}

	public void setContainService(ContainService containService) {
		this.containService = containService;
	}

	public KindOfKeyService getKindOfKeyService() {
		return kindOfKeyService;
	}

	public void setKindOfKeyService(KindOfKeyService kindOfKeyService) {
		this.kindOfKeyService = kindOfKeyService;
	}

	public List<CountObject> getCountObjectList() {
		return countObjectList;
	}

	public void setCountObjectList(List<CountObject> countObjectList) {
		this.countObjectList = countObjectList;
	}

	public KeyAsk getKeyAsk() {
		return keyAsk;
	}

	public void setKeyAsk(KeyAsk keyAsk) {
		this.keyAsk = keyAsk;
	}

	public String getAskDate() {
		return askDate;
	}

	public void setAskDate(String askDate) {
		this.askDate = askDate;
	}

	public KindOfKey getKindOfKey() {
		return kindOfKey;
	}

	public void setKindOfKey(KindOfKey kindOfKey) {
		this.kindOfKey = kindOfKey;
	}

	public List<KeyAsk> getKeyAskList() {
		return keyAskList;
	}

	public void setKeyAskList(List<KeyAsk> keyAskList) {
		this.keyAskList = keyAskList;
	}
}
