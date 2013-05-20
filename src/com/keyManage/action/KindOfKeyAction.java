package com.keyManage.action;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.util.Assert;

import com.keyManage.base.PaginationSupport;
import com.keyManage.bean.KindOfKey;
import com.keyManage.bean.Manager;
import com.keyManage.service.kindOfKey.KindOfKeyService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class KindOfKeyAction extends ActionSupport {

	private KindOfKey kindOfKey;
	private KindOfKeyService kindOfKeyService;
	private int currentPage;
	private PaginationSupport paginationSupport;
	private String kindOfKeyId;

	// 初始化
	public String init() {
		if(kindOfKeyId!=null){
			kindOfKey=kindOfKeyService.findByPrimaryKey(kindOfKeyId);
		}
		if(currentPage<=1){
			currentPage=1;
		}
		try {
			Map<String, Object> params=new HashMap<String, Object>();
			params.put("isDelete", "1");
			paginationSupport=kindOfKeyService.findByPage(params, currentPage, 2);
			return "init";
		} catch (DataAccessException e) {
			return ERROR;
		}
	}

	public String add() {
		try {
			if(kindOfKey.getId()==null||kindOfKey.getId().equals("")){
			//新建保存
				Manager manager = (Manager)ActionContext.getContext().getSession().get("manager");
				Assert.notNull(kindOfKey);
				kindOfKey.setIsDelete("1");
				kindOfKey.setManagerByCreateBy(manager);
				kindOfKey.setCreateDate(new Timestamp(System
						.currentTimeMillis()));
				kindOfKeyService.addKindOfKey(kindOfKey);
			}else{
			//修改保存
				kindOfKeyService.update(kindOfKey);
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
			kindOfKeyService.removeAll(ids);
			return SUCCESS;
		} catch (DataAccessException e) {
			return ERROR;
		}
	}

	public KindOfKey getKindOfKey() {
		return kindOfKey;
	}

	public void setKindOfKey(KindOfKey kindOfKey) {
		this.kindOfKey = kindOfKey;
	}

	public KindOfKeyService getKindOfKeyService() {
		return kindOfKeyService;
	}

	public void setKindOfKeyService(KindOfKeyService kindOfKeyService) {
		this.kindOfKeyService = kindOfKeyService;
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

	public String getKindOfKeyId() {
		return kindOfKeyId;
	}

	public void setKindOfKeyId(String kindOfKeyId) {
		this.kindOfKeyId = kindOfKeyId;
	}

}
