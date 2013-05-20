package com.keyManage.service.kindOfKey;

import java.util.Map;

import com.keyManage.base.PaginationSupport;
import com.keyManage.bean.KindOfKey;

public interface KindOfKeyService {

	public void addKindOfKey(KindOfKey kindOfKey);
	public PaginationSupport findByPage(Map<String, Object> params,int currentPage, int pageSize);
}
