package com.keyManage.service.kindOfKey;

import java.util.Map;

import com.keyManage.base.PaginationSupport;
import com.keyManage.bean.KindOfKey;
import com.keyManage.dao.kindOfKey.KindOfKeyDAO;

public class KindOfKeyServiceImpl implements KindOfKeyService {
	private KindOfKeyDAO kindOfKeyDAO;

	@Override
	public void addKindOfKey(KindOfKey kindOfKey) {
		kindOfKeyDAO.insert(kindOfKey);

	}
	
	public PaginationSupport findByPage(Map<String, Object> params,int currentPage, int pageSize){
		return kindOfKeyDAO.findByPage(params, currentPage, pageSize);
	}
	

	public KindOfKeyDAO getKindOfKeyDAO() {
		return kindOfKeyDAO;
	}

	public void setKindOfKeyDAO(KindOfKeyDAO kindOfKeyDAO) {
		this.kindOfKeyDAO = kindOfKeyDAO;
	}
	
}
