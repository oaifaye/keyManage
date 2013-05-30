package com.keyManage.service.procedureVersion;

import java.util.List;
import java.util.Map;

import com.keyManage.base.PaginationSupport;
import com.keyManage.bean.ProcedureVersion;

public interface ProcedureVersionService {

	public void addProcedureVersion(ProcedureVersion procedureVersion);
	public PaginationSupport findByPage(Map<String, Object> params,int currentPage, int pageSize);
	/**逻辑删*/
	public void update(ProcedureVersion procedureVersion);
	public void removeAll(String[] ids);
	public ProcedureVersion findByPrimaryKey(String id);
	public List<ProcedureVersion> findListByParams(Map<String, Object> params);
}
