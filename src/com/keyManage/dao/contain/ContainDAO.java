package com.keyManage.dao.contain;

import java.util.List;

import com.keyManage.base.HibernateGenericDAO;
import com.keyManage.bean.Contain;
import com.keyManage.util.CountObject;

public interface ContainDAO extends HibernateGenericDAO<Contain> {
	/**
	 * 按KindOfKeyID算取各种锁的剩余数量
	 * */
	public List<CountObject> findCountByKindOfKeyID(String saveOrTake);
}
