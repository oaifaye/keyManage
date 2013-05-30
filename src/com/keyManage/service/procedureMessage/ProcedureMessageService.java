package com.keyManage.service.procedureMessage;

import java.util.List;
import java.util.Map;

import com.keyManage.base.PaginationSupport;
import com.keyManage.bean.ProcedureMessage;

public interface ProcedureMessageService {

	public void addProcedureMessage(ProcedureMessage procedureMessage);
	public PaginationSupport findByPage(Map<String, Object> params,int currentPage, int pageSize);
	/**逻辑删*/
	public void update(ProcedureMessage procedureMessage);
	public void removeAll(String[] ids);
	public ProcedureMessage findByPrimaryKey(String id);
	public List<ProcedureMessage> findListByParams(Map<String, Object> params);
}
