package com.keyManage.service.purpose;

import java.util.List;
import java.util.Map;

import com.keyManage.base.PaginationSupport;
import com.keyManage.bean.Purpose;
import com.keyManage.dao.purpose.PurposeDAO;

public class PurposeServiceImpl implements PurposeService {
	private PurposeDAO purposeDAO;

	@Override
	public void addPurpose(Purpose purpose) {
		purposeDAO.insert(purpose);

	}
	
	public void update(Purpose purpose){
		purposeDAO.update(purpose);
	}
	
	@Override
	public void removeAll(String[] ids){
		Purpose purpose;
		for(String id:ids){
			purpose=purposeDAO.findByPrimaryKey(id);
			purpose.setIsDelete("0");
			purposeDAO.update(purpose);
		}
	}
	
	@Override
	public List<Purpose> findListByParams(Map<String, Object> params) {
		return  purposeDAO.findListByParams(params);
	}
	
	public Purpose findByPrimaryKey(String id){
		return purposeDAO.findByPrimaryKey(id);
	}
	
	public PaginationSupport findByPage(Map<String, Object> params,int currentPage, int pageSize){
		return purposeDAO.findByPage(params, currentPage, pageSize);
	}
	

	public PurposeDAO getPurposeDAO() {
		return purposeDAO;
	}

	public void setPurposeDAO(PurposeDAO purposeDAO) {
		this.purposeDAO = purposeDAO;
	}

}
