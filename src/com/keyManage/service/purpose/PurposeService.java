package com.keyManage.service.purpose;

import java.util.List;
import java.util.Map;

import com.keyManage.base.PaginationSupport;
import com.keyManage.bean.Purpose;

public interface PurposeService {

	public void addPurpose(Purpose purpose);
	public PaginationSupport findByPage(Map<String, Object> params,int currentPage, int pageSize);
	/**逻辑删*/
	public void update(Purpose purpose);
	public void removeAll(String[] ids);
	public Purpose findByPrimaryKey(String id);
	public List<Purpose> findListByParams(Map<String, Object> params);
}
