package com.keyManage.service.keyAsk;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import com.keyManage.base.PaginationSupport;
import com.keyManage.bean.KeyAsk;
import com.keyManage.bean.KeyMessage;

public interface KeyAskService {
	public void addKeyAsk(KeyAsk keyAsk);
	public List<KeyAsk> findListByParams(Map<String, Object> params);
	/**
	 * 分页（锁管理员用）
	 * */
	public PaginationSupport findKeyAskByPage(int currentPage,int pageSize);
	/**
	 * 分页（锁领取人用）
	 * */
	public PaginationSupport findKeyAskByPage(String createById,int currentPage,int pageSize);
	public KeyAsk findByPrimaryKey(String keyAskId);
	public void updateKeyAsk(KeyAsk keyAsk);
	public PaginationSupport findByPage(final Map<String, Object> params,
			final int currentPage, final int pageSize);
	/**自定义查询*/
	public List<KeyAsk> findListByParams(Map<String, Object> params,Map<String, Object> likeParams,Map<String, Timestamp[]> betweenParams,Map<String, String[]> inParams);
	
}
