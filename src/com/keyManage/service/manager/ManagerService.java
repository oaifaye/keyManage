package com.keyManage.service.manager;

import java.util.List;
import java.util.Map;

import com.keyManage.base.PaginationSupport;
import com.keyManage.bean.KindOfKey;
import com.keyManage.bean.Manager;

public interface ManagerService {
	/**
	 * 后台登录查询
	 * */
	public Manager getLoginPerson(Map<String, Object> params);
	/**添加用户*/
	public void addManager(Manager manager);
	public void removeAll(String[] ids);
	public void update(Manager manager);
	public List<Manager> findListByParams(Map<String, Object> params);
	public PaginationSupport findByPage(Map<String, Object> params,int currentPage, int pageSize);
	public Manager findByPrimaryKey(String id);
}
