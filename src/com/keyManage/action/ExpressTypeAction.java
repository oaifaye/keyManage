package com.keyManage.action;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.util.Assert;

import com.keyManage.base.PaginationSupport;
import com.keyManage.bean.ExpressType;
import com.keyManage.bean.Manager;
import com.keyManage.service.expressType.ExpressTypeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ExpressTypeAction extends ActionSupport {

	private ExpressType expressType;
	private ExpressTypeService expressTypeService;
	private int currentPage;
	private PaginationSupport paginationSupport;
	private String expressTypeId;

	// 初始化
	public String init() {
		if(expressTypeId!=null){
			expressType=expressTypeService.findByPrimaryKey(expressTypeId);
		}
		if(currentPage<=1){
			currentPage=1;
		}
		try {
			Map<String, Object> params=new HashMap<String, Object>();
			params.put("isDelete", "1");
			paginationSupport=expressTypeService.findByPage(params, currentPage, 2);
			return "init";
		} catch (DataAccessException e) {
			return ERROR;
		}
	}

	public String add() {
		try {
			if(expressType.getId()==null||expressType.getId().equals("")){
			//新建保存
				Manager manager = (Manager)ActionContext.getContext().getSession().get("manager");
				Assert.notNull(expressType);
				expressType.setIsDelete("1");
				expressType.setManagerByCreateBy(manager);
				expressType.setCreateDate(new Timestamp(System
						.currentTimeMillis()));
				expressTypeService.addExpressType(expressType);
			}else{
			//修改保存
				expressTypeService.update(expressType);
			}
			return SUCCESS;
		} catch (DataAccessException e) {
			return ERROR;
		}
	}
	
	//逻辑删
	public String removeAll(){
		try {
			String[] ids=(String[]) ActionContext.getContext().getParameters().get("ids");
			expressTypeService.removeAll(ids);
			return SUCCESS;
		} catch (DataAccessException e) {
			return ERROR;
		}
	}

	public ExpressType getExpressType() {
		return expressType;
	}

	public void setExpressType(ExpressType expressType) {
		this.expressType = expressType;
	}


	public ExpressTypeService getExpressTypeService() {
		return expressTypeService;
	}

	public void setExpressTypeService(
			ExpressTypeService expressTypeService) {
		this.expressTypeService = expressTypeService;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public PaginationSupport getPaginationSupport() {
		return paginationSupport;
	}

	public void setPaginationSupport(PaginationSupport paginationSupport) {
		this.paginationSupport = paginationSupport;
	}

	public String getExpressTypeId() {
		return expressTypeId;
	}

	public void setExpressTypeId(String expressTypeId) {
		this.expressTypeId = expressTypeId;
	}

}
