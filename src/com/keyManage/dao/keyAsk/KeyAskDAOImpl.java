package com.keyManage.dao.keyAsk;

import com.keyManage.base.HibernateGenericDAOImpl;
import com.keyManage.base.PaginationSupport;
import com.keyManage.bean.KeyAsk;

public class KeyAskDAOImpl extends HibernateGenericDAOImpl<KeyAsk> implements
		KeyAskDAO {

	public PaginationSupport findKeyAskByPage(int currentPage,int pageSize){
		String hql="FROM KeyAsk WHERE IsDelete='1' ORDER BY IsFinished DESC ,CreateDate DESC";
		PaginationSupport paginationSupport=super.findByPage(hql, currentPage, pageSize);
		return paginationSupport;
	}
	
	public PaginationSupport findKeyAskByPage(String createById,int currentPage,int pageSize){
		String hql="FROM KeyAsk WHERE IsDelete='1' AND CreateBy='"+createById+"' ORDER BY IsFinished DESC ,CreateDate DESC";
		PaginationSupport paginationSupport=super.findByPage(hql, currentPage, pageSize);
		return paginationSupport;
	}

}
