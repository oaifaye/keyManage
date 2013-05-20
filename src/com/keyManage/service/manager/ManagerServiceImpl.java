package com.keyManage.service.manager;


import java.util.Map;

import com.keyManage.bean.Manager;
import com.keyManage.dao.manager.ManagerDAO;

public class ManagerServiceImpl implements ManagerService {
	private ManagerDAO managerDAO;
	
	/**
	 * 后台登录查询
	 * */
//	public Manager getLoginPerson(String userName, String password) {
//		return managerDAO.getLoginPerson(userName, password);
//	}
	
	public Manager getLoginPerson(Map<String, Object> params) {
		//return managerDAO.getLoginPerson(userName, password);
		return managerDAO.findUniqueByParams(params);
	}
	

	public ManagerDAO getManagerDAO() {
		return managerDAO;
	}

	public void setManagerDAO(ManagerDAO managerDAO) {
		this.managerDAO = managerDAO;
	}

}
