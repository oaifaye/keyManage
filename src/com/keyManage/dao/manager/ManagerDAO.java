package com.keyManage.dao.manager;

import com.keyManage.base.HibernateGenericDAO;
import com.keyManage.bean.Manager;



public interface ManagerDAO extends HibernateGenericDAO<Manager>{
	/**
	 * 后台登录查询
	 * */
	public Manager getLoginPerson(String userName, String password);
}
