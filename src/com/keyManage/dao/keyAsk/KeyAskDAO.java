package com.keyManage.dao.keyAsk;

import com.keyManage.base.HibernateGenericDAO;
import com.keyManage.base.PaginationSupport;
import com.keyManage.bean.KeyAsk;

public interface KeyAskDAO extends HibernateGenericDAO<KeyAsk> {
	public PaginationSupport findKeyAskByPage(int currentPage,int pageSize);
	public PaginationSupport findKeyAskByPage(String createById,int currentPage,int pageSize);
}
