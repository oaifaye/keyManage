package com.keyManage.dao.keyMessage;

import java.util.List;

import com.keyManage.base.HibernateGenericDAO;
import com.keyManage.bean.KeyMessage;
import com.keyManage.util.CountObject;

public interface KeyMessageDAO extends HibernateGenericDAO<KeyMessage> {
	/**
	 * 根据批号id计算每批的批号——总锁数
	 * */
	public List<CountObject> findNumByContainIds(String[] containIds);
	
	/**
	 * 计算一个请求单中的已经使用的锁的数量
	 * */
	public Integer findNumOfUsed(String keyAskId);
}
