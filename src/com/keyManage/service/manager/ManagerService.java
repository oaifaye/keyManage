package com.keyManage.service.manager;

import java.util.Map;

import com.keyManage.bean.Manager;

public interface ManagerService {
	/**
	 * 后台登录查询
	 * */
	//public Manager getLoginPerson(String userName, String password) ;
	public Manager getLoginPerson(Map<String, Object> params);
}
