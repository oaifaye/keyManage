package com.keyManage.dao.keyAsk;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.hibernate.criterion.Restrictions;

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
	
//	public PaginationSupport findKeyAskByPage(Map<String, Object> params,int currentPage,int pageSize){
//		
//		String hql="FROM KeyAsk WHERE IsDelete='1' " ;
//				// 获取params全部的key
//				Set<String> keySet = params.keySet();
//				Iterator<String> keyIterator = keySet.iterator();
//				while (keyIterator.hasNext()) {
//					String key = keyIterator.next();
//					crit.add(Restrictions.eq(key, params.get(key)));
//				}
//				"AND CreateBy='"+createById+"' ORDER BY IsFinished DESC ,CreateDate DESC";
//		PaginationSupport paginationSupport=super.findByPage(hql, currentPage, pageSize);
//		return paginationSupport;
//	}

}
