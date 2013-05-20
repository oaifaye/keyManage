package com.keyManage.action;

import java.util.HashMap;
import java.util.Map;

import com.keyManage.bean.Manager;
import com.keyManage.service.manager.ManagerService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ManagerAction extends ActionSupport {
	private String  userName,
					password;
	private ManagerService managerService;
	
	/**
	 * 后台登陆验证
	 * */
	public String login(){
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("userName", userName);
		params.put("password", password);
		params.put("isDelete", "1");
		Manager manager=managerService.getLoginPerson(params);
		if(manager==null){
			addFieldError("error","用户名或密码错");
			return ERROR;
		}else{
			ActionContext.getContext().getSession().put("manager", manager);
			ActionContext.getContext().getSession().put("managerUserName", userName);
			return "loginSuccess";
		}
	}
	
	/**初始化index.jsp*/
	public String init(){
		return "init";
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ManagerService getManagerService() {
		return managerService;
	}

	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}
	
}
