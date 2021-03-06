package com.keyManage.service.keyAsk;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import com.keyManage.base.PaginationSupport;
import com.keyManage.bean.KeyAsk;
import com.keyManage.bean.KeyMessage;
import com.keyManage.dao.keyAsk.KeyAskDAO;

public class KeyAskServiceImpl implements KeyAskService {
	private KeyAskDAO keyAskDAO;

	public void addKeyAsk(KeyAsk keyAsk){
		keyAskDAO.insert(keyAsk);
	}
	
	public List<KeyAsk> findListByParams(Map<String, Object> params){
		return keyAskDAO.findListByParams(params);
	}
	
	@Override
	public PaginationSupport findKeyAskByPage(int currentPage, int pageSize) {
		return keyAskDAO.findKeyAskByPage(currentPage, pageSize);
	}
	
	@Override
	public PaginationSupport findKeyAskByPage(String createById,
			int currentPage, int pageSize) {
		return keyAskDAO.findKeyAskByPage(createById, currentPage, pageSize);
	}
	
	@Override
	public KeyAsk findByPrimaryKey(String keyAskId) {
		return keyAskDAO.findByPrimaryKey(keyAskId);
	}
	
	public PaginationSupport findByPage(final Map<String, Object> params,
			final int currentPage, final int pageSize){
		return keyAskDAO.findByPage(params, currentPage, pageSize);
	}
	
	@Override
	public List<KeyAsk> findListByParams(Map<String, Object> params,
			Map<String, Object> likeParams,
			Map<String, Timestamp[]> betweenParams,
			Map<String, String[]> inParams) {
		return keyAskDAO.findListByParams(params, likeParams, betweenParams, inParams);
	}

	
	public void updateKeyAsk(KeyAsk keyAsk){
		keyAskDAO.update(keyAsk);
	}
	
	
	public KeyAskDAO getKeyAskDAO() {
		return keyAskDAO;
	}

	public void setKeyAskDAO(KeyAskDAO keyAskDAO) {
		this.keyAskDAO = keyAskDAO;
	}


}
