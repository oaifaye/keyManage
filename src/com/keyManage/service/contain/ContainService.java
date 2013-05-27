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
//	public List findCountByKindOfKeyID(String saveOrTake) ;
//	public List findCountIDByKindOfKeyID(String saveOrTake) ;
	/**
	 * 按KindOfKeyID算取各种锁的剩余数量
	 * */
	public List<CountObject> findLastKey();
}
