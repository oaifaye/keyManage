package com.keyManage.service.keyMessage;

import com.keyManage.bean.KeyMessage;
import com.keyManage.dao.keyMessage.KeyMessageDAO;

public class KeyMessageServiceImpl implements KeyMessageService {
	private KeyMessageDAO keyMessageDAO;

	public void addKeyMessage(KeyMessage keyMessage){
		keyMessageDAO.insert(keyMessage);
	}
	
	public KeyMessageDAO getKeyMessageDAO() {
		return keyMessageDAO;
	}

	public void setKeyMessageDAO(KeyMessageDAO keyMessageDAO) {
		this.keyMessageDAO = keyMessageDAO;
	}
}
