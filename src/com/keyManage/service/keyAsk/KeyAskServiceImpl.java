package com.keyManage.service.keyAsk;

import java.util.List;
import java.util.Map;

import com.keyManage.bean.KeyAsk;
import com.keyManage.dao.keyAsk.KeyAskDAO;

public class KeyAskServiceImpl implements KeyAskService {
	private KeyAskDAO keyAskDAO;

	public void addKeyAsk(KeyAsk keyAsk){
		keyAskDAO.insert(keyAsk);
	}
	
	public List<KeyAsk> findListByParams(Map<String, Object> params){
		return keyAskDAO.findListByParams(params);
	}
	
	
	public KeyAskDAO getKeyAskDAO() {
		return keyAskDAO;
	}

	public void setKeyAskDAO(KeyAskDAO keyAskDAO) {
		this.keyAskDAO = keyAskDAO;
	}

}
