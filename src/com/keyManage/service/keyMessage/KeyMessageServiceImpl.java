package com.keyManage.service.keyMessage;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import com.keyManage.bean.KeyMessage;
import com.keyManage.dao.keyMessage.KeyMessageDAO;

public class KeyMessageServiceImpl implements KeyMessageService {
	private KeyMessageDAO keyMessageDAO;

	public void addKeyMessage(KeyMessage keyMessage){
		keyMessageDAO.insert(keyMessage);
	}
	@Override
	public KeyMessage findByPrimaryKey(String keyMessageId) {
		return keyMessageDAO.findByPrimaryKey(keyMessageId);
	}
	@Override
	public List<KeyMessage> findListByParams(Map<String, Object> params,Map<String, Object> likeParams,Map<String, Timestamp[]> betweenParams,Map<String, String[]> inParams) {
		return keyMessageDAO.findListByParams(params, likeParams,betweenParams,inParams);
	}

	@Override
	public void updateKeyMessage(KeyMessage keyMessage) {
		keyMessageDAO.update(keyMessage);
	}
	
	public KeyMessageDAO getKeyMessageDAO() {
		return keyMessageDAO;
	}

	public void setKeyMessageDAO(KeyMessageDAO keyMessageDAO) {
		this.keyMessageDAO = keyMessageDAO;
	}
	
	
	
}
