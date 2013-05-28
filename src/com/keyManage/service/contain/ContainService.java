package com.keyManage.service.contain;

import java.util.List;
import java.util.Map;

import com.keyManage.base.PaginationSupport;
import com.keyManage.bean.Contain;
import com.keyManage.util.CountObject;

public interface ContainService {
	
	public void addContain(Contain contain);
	public void update(Contain contain);
	public void removeAll(String[] ids);
	public Contain findByPrimaryKey(String id);
	public List<Contain> findListByParams(Map<String, Object> params);
	public PaginationSupport findByPage(Map<String, Object> params,int currentPage, int pageSize);
	/**
	 * 按KindOfKeyID算取各种锁的剩余数量
	 * */
	public List<CountObject> findLastKey();
	/**
	 * 按KindOfKeyID和批号算取各种锁的剩余数量
	 * */
	public List<CountObject> findLastKey(String kindOfKeyID);
	/**
	 * 批量插入
	 * */
	public void addAllContain(List<Contain> containList);
	/**
	 * 按请求锁的id查询锁的已满足数量
	 * */
	public Integer findCountNumByKeyAskID(String keyAskID,String isDelete);
	
}
