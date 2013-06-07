package com.keyManage.service.manager;


import java.util.List;
import java.util.Map;

import com.keyManage.base.PaginationSupport;
import com.keyManage.bean.KindOfKey;
import com.keyManage.bean.Manager;
import com.keyManage.dao.manager.ManagerDAO;

public class ManagerServiceImpl implements ManagerService {
	private ManagerDAO managerDAO;
	
	/**
	 * 后台登录查询
	 * */
	public Manager getLoginPerson(Map<String, Object> params) {
		return managerDAO.findUniqueByParams(params);
	}
	
	@Override
	public void addManager(Manager manager) {
		managerDAO.insert(manager);
	}

	public void update(Manager manager){
		managerDAO.update(manager);
	}
	
	@Override
	public void removeAll(String[] ids){
		Manager manager;
		for(String id:ids){
			manager=managerDAO.findByPrimaryKey(id);
			manager.setIsDelete("0");
			managerDAO.update(manager);
		}
	}
	
	public Manager findByPrimaryKey(String id){
		return managerDAO.findByPrimaryKey(id);
	}
	
	public List<Manager> findListByParams(Map<String, Object> params){
		return managerDAO.findListByParams(params);
	}
	
	public PaginationSupport findByPage(Map<String, Object> params,int currentPage, int pageSize){
		return managerDAO.findByPage(params, currentPage, pageSize);
	}
	
	public ManagerDAO getManagerDAO() {
		return managerDAO;
	}

	public void setManagerDAO(ManagerDAO managerDAO) {
		this.managerDAO = managerDAO;
	}


	

}
