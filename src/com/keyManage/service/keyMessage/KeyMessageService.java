package com.keyManage.service.keyMessage;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import com.keyManage.bean.KeyMessage;

public interface KeyMessageService {
	public void addKeyMessage(KeyMessage keyMessage);
	public KeyMessage findByPrimaryKey(String keyMessageId);
	/**自定义查询*/
	public List<KeyMessage> findListByParams(Map<String, Object> params,Map<String, Object> likeParams,Map<String, Timestamp[]> betweenParams,Map<String, String[]> inParams);
	/**修改*/
	public void updateKeyMessage(KeyMessage keyMessage);
	
}
