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
}
