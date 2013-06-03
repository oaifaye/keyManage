package com.keyManage.service.expressType;

import java.util.List;
import java.util.Map;

import com.keyManage.base.PaginationSupport;
import com.keyManage.bean.ExpressType;
import com.keyManage.dao.expressType.ExpressTypeDAO;

public class ExpressTypeServiceImpl implements ExpressTypeService {
	private ExpressTypeDAO expressTypeDAO;

	@Override
	public void addExpressType(ExpressType expressType) {
		expressTypeDAO.insert(expressType);

	}
	
	public void update(ExpressType expressType){
		expressTypeDAO.update(expressType);
	}
	
	@Override
	public void removeAll(String[] ids){
		ExpressType expressType;
		for(String id:ids){
			expressType=expressTypeDAO.findByPrimaryKey(id);
			expressType.setIsDelete("0");
			expressTypeDAO.update(expressType);
		}
	}
	
	@Override
	public List<ExpressType> findListByParams(Map<String, Object> params) {
		return  expressTypeDAO.findListByParams(params);
	}
	
	public ExpressType findByPrimaryKey(String id){
		return expressTypeDAO.findByPrimaryKey(id);
	}
	
	public PaginationSupport findByPage(Map<String, Object> params,int currentPage, int pageSize){
		return expressTypeDAO.findByPage(params, currentPage, pageSize);
	}
	

	public ExpressTypeDAO getExpressTypeDAO() {
		return expressTypeDAO;
	}

	public void setExpressTypeDAO(ExpressTypeDAO expressTypeDAO) {
		this.expressTypeDAO = expressTypeDAO;
	}

}
