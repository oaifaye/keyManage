package com.keyManage.service.expressType;

import java.util.List;
import java.util.Map;

import com.keyManage.base.PaginationSupport;
import com.keyManage.bean.ExpressType;

public interface ExpressTypeService {

	public void addExpressType(ExpressType expressType);
	public PaginationSupport findByPage(Map<String, Object> params,int currentPage, int pageSize);
	/**逻辑删*/
	public void update(ExpressType expressType);
	public void removeAll(String[] ids);
	public ExpressType findByPrimaryKey(String id);
	public List<ExpressType> findListByParams(Map<String, Object> params);
}
