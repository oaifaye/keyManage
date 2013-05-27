package com.keyManage.service.keyAsk;

import java.util.List;
import java.util.Map;

import com.keyManage.bean.KeyAsk;

public interface KeyAskService {
	public void addKeyAsk(KeyAsk keyAsk);
	public List<KeyAsk> findListByParams(Map<String, Object> params);
}
