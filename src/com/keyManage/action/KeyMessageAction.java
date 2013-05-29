package com.keyManage.action;

import org.springframework.util.Assert;

import com.keyManage.bean.Contain;
import com.keyManage.bean.KeyMessage;
import com.keyManage.service.contain.ContainService;
import com.keyManage.service.keyMessage.KeyMessageService;
import com.opensymphony.xwork2.ActionSupport;

public class KeyMessageAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private KeyMessageService keyMessageService;
	private ContainService containService;
	private KeyMessage keyMessage;
	private String containId;
	//初始化添加锁用途页面
	public String initAddKey(){
		return "initAddKey";
	}
	
	//添加锁信息
	public String addKey(){
		Assert.notNull(keyMessage);
		Contain contain = containService.findByPrimaryKey(containId);
		
		keyMessage.setContain(contain);
		keyMessageService.addKeyMessage(keyMessage);
		return "addKey";
	}
	
	
	public KeyMessageService getKeyMessageService() {
		return keyMessageService;
	}
	public void setKeyMessageService(KeyMessageService keyMessageService) {
		this.keyMessageService = keyMessageService;
	}
	public KeyMessage getKeyMessage() {
		return keyMessage;
	}
	public void setKeyMessage(KeyMessage keyMessage) {
		this.keyMessage = keyMessage;
	}
	public String getContainId() {
		return containId;
	}
	public void setContainId(String containId) {
		this.containId = containId;
	}
	public ContainService getContainService() {
		return containService;
	}
	public void setContainService(ContainService containService) {
		this.containService = containService;
	}
}
