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
	 * 按请求锁的id（keyAskId）查询锁的已满足数量
	 * */
	public Integer findCountNumByKeyAskID(String keyAskID,String isDelete);
	/**
	 * 按KindOfKeyID和批号算取各种锁的总数量
	 * */
	public List<CountObject> findCountLotNumberByKindOfKeyID(String saveOrTake,String kindOfKeyID);
	/**
	 * 计算已经批准的每批锁的未使用（未填写通途）数量
	 * */
	public List<Contain> findLastNumOfContain(String keyAskId);
	/**计算一个请求单中的已经使用的锁的数量*/
	public Integer findNumOfUsed(String keyAskId);
	/**按锁种类id查询库中剩余数量*/
	public Integer findNumByKindOfKeyID(String kindOfKeyID);
	
}
