package com.keyManage.action;

import org.springframework.dao.DataAccessException;
import org.springframework.util.Assert;

import com.keyManage.base.DaoException;
import com.keyManage.bean.Contain;
import com.keyManage.service.contain.ContainService;
import com.opensymphony.xwork2.ActionSupport;

public class ContainAction extends ActionSupport {
	private Contain contain;
	private ContainService containService;

	//初始化
	public String initContain(){
		return "init";
	}
	
	public String addContain(){
		try {
			Assert.notNull(contain);
			containService.addContain(contain);
			return "addSuccess";
		} catch (DataAccessException e) {
			return ERROR;
		}
	}
	
	
	
	public Contain getContain() {
		return contain;
	}

	public void setContain(Contain contain) {
		this.contain = contain;
	}

	public ContainService getContainService() {
		return containService;
	}

	public void setContainService(ContainService containService) {
		this.containService = containService;
	}
	
	
}
