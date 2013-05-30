package com.keyManage.service.procedureMessage;

import java.util.List;
import java.util.Map;

import com.keyManage.base.PaginationSupport;
import com.keyManage.bean.ProcedureMessage;
import com.keyManage.dao.procedureMessage.ProcedureMessageDAO;

public class ProcedureMessageServiceImpl implements ProcedureMessageService {
	private ProcedureMessageDAO procedureMessageDAO;

	@Override
	public void addProcedureMessage(ProcedureMessage procedureMessage) {
		procedureMessageDAO.insert(procedureMessage);

	}
	
	public void update(ProcedureMessage procedureMessage){
		procedureMessageDAO.update(procedureMessage);
	}
	
	@Override
	public void removeAll(String[] ids){
		ProcedureMessage procedureMessage;
		for(String id:ids){
			procedureMessage=procedureMessageDAO.findByPrimaryKey(id);
			procedureMessage.setIsDelete("0");
			procedureMessageDAO.update(procedureMessage);
		}
	}
	
	@Override
	public List<ProcedureMessage> findListByParams(Map<String, Object> params) {
		return  procedureMessageDAO.findListByParams(params);
	}
	
	public ProcedureMessage findByPrimaryKey(String id){
		return procedureMessageDAO.findByPrimaryKey(id);
	}
	
	public PaginationSupport findByPage(Map<String, Object> params,int currentPage, int pageSize){
		return procedureMessageDAO.findByPage(params, currentPage, pageSize);
	}
	

	public ProcedureMessageDAO getProcedureMessageDAO() {
		return procedureMessageDAO;
	}

	public void setProcedureMessageDAO(ProcedureMessageDAO procedureMessageDAO) {
		this.procedureMessageDAO = procedureMessageDAO;
	}

}
