package com.keyManage.dao.contain;

import java.util.List;

import com.keyManage.base.HibernateGenericDAO;
import com.keyManage.bean.Contain;
import com.keyManage.util.CountObject;

public interface ContainDAO extends HibernateGenericDAO<Contain> {
	/**
	 * 按KindOfKeyID算取各种锁的数量
	 * */
	public List<CountObject> findCountByKindOfKeyID(String saveOrTake);
	
	/**
	 * 按KindOfKeyID和批号算取各种锁的总数量
	 * */
	public List<CountObject> findCountLotNumberByKindOfKeyID(String saveOrTake,String kindOfKeyID);
	
	/**
	 * 按请求锁的id查询锁的数量
	 * */
	public Integer findCountNumByKeyAskID(String keyAskID,String isDelete);
	
	/**
	 * 批量插入
	 * */
	public void insertAllContain(List<Contain> ContainList);
	
}
