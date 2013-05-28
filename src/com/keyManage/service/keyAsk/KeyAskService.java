package com.keyManage.service.keyAsk;

import java.util.List;
import java.util.Map;

import com.keyManage.base.PaginationSupport;
import com.keyManage.bean.KeyAsk;

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
}
