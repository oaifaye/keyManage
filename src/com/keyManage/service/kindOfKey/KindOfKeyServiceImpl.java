package com.keyManage.service.kindOfKey;

import java.util.List;
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
	
	public void update(KindOfKey kindOfKey){
		kindOfKeyDAO.update(kindOfKey);
	}
	
	@Override
	public void removeAll(String[] ids){
		KindOfKey kindOfKey;
		for(String id:ids){
			kindOfKey=kindOfKeyDAO.findByPrimaryKey(id);
			kindOfKey.setIsDelete("0");
			kindOfKeyDAO.update(kindOfKey);
		}
	}
	
	@Override
	public List<KindOfKey> findListByParams(Map<String, Object> params) {
		return  kindOfKeyDAO.findListByParams(params);
	}
	
	public KindOfKey findByPrimaryKey(String id){
		return kindOfKeyDAO.findByPrimaryKey(id);
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
