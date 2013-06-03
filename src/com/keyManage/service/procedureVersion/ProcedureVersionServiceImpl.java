package com.keyManage.service.procedureVersion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.keyManage.base.PaginationSupport;
import com.keyManage.bean.Department;
import com.keyManage.bean.ProcedureVersion;
import com.keyManage.dao.procedureVersion.ProcedureVersionDAO;

public class ProcedureVersionServiceImpl implements ProcedureVersionService {
	private ProcedureVersionDAO procedureVersionDAO;

	@Override
	public void addProcedureVersion(ProcedureVersion procedureVersion) {
		procedureVersionDAO.insert(procedureVersion);

	}
	
	public void update(ProcedureVersion procedureVersion){
		procedureVersionDAO.update(procedureVersion);
	}
	
	@Override
	public void removeAll(String[] ids){
		ProcedureVersion procedureVersion;
		for(String id:ids){
			procedureVersion=procedureVersionDAO.findByPrimaryKey(id);
			procedureVersion.setIsDelete("0");
			procedureVersionDAO.update(procedureVersion);
		}
	}
	
	//dwr
		public Map<String, String> findByProcedureMessageIdDwr(ArrayList<String> array){
			String procedureMessageId = array.get(0);
			String isDelete = array.get(1);
			Map<String, Object> params=new HashMap<String, Object>();
			params.put("procedureMessage.id", procedureMessageId);
			params.put("isDelete", isDelete);
			List<ProcedureVersion> procedureVersionList = procedureVersionDAO.findListByParams(params);
			Map<String, String> procedureVersionMap=new HashMap<String, String>();
			if(procedureVersionList!=null){
				for(int i=0;i<procedureVersionList.size();i++){
					procedureVersionMap.put(procedureVersionList.get(i).getId(), procedureVersionList.get(i).getVersionName());
				}
			}
			return procedureVersionMap;
		}
	
	
	@Override
	public List<ProcedureVersion> findListByParams(Map<String, Object> params) {
		return  procedureVersionDAO.findListByParams(params);
	}
	
	public ProcedureVersion findByPrimaryKey(String id){
		return procedureVersionDAO.findByPrimaryKey(id);
	}
	
	public PaginationSupport findByPage(Map<String, Object> params,int currentPage, int pageSize){
		return procedureVersionDAO.findByPage(params, currentPage, pageSize);
	}
	

	public ProcedureVersionDAO getProcedureVersionDAO() {
		return procedureVersionDAO;
	}

	public void setProcedureVersionDAO(ProcedureVersionDAO procedureVersionDAO) {
		this.procedureVersionDAO = procedureVersionDAO;
	}

}
