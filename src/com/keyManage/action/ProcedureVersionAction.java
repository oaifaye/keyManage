package com.keyManage.action;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.util.Assert;

import com.keyManage.base.PaginationSupport;
import com.keyManage.bean.ProcedureMessage;
import com.keyManage.bean.ProcedureVersion;
import com.keyManage.bean.Manager;
import com.keyManage.service.procedureMessage.ProcedureMessageService;
import com.keyManage.service.procedureVersion.ProcedureVersionService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ProcedureVersionAction extends ActionSupport {

	private ProcedureVersion procedureVersion;
	private ProcedureVersionService procedureVersionService;
	private int currentPage;
	private PaginationSupport paginationSupport;
	private String procedureVersionId;
	private ProcedureMessageService procedureMessageService;
	private List<ProcedureMessage> procedureMessageList;

	// 初始化
	public String init() {
		if(procedureVersionId!=null){
			procedureVersion=procedureVersionService.findByPrimaryKey(procedureVersionId);
		}
		if(currentPage<=1){
			currentPage=1;
		}
		try {
			Map<String, Object> params=new HashMap<String, Object>();
			params.put("isDelete", "1");
			//初始化程序名称
			procedureMessageList=procedureMessageService.findListByParams(params);
			paginationSupport=procedureVersionService.findByPage(params, currentPage, 2);
			return "init";
		} catch (DataAccessException e) {
			return ERROR;
		}
	}

	public String add() {
		try {
			if(procedureVersion.getId()==null||procedureVersion.getId().equals("")){
			//新建保存
				Manager manager = (Manager)ActionContext.getContext().getSession().get("manager");
				Assert.notNull(procedureVersion);
				procedureVersion.setIsDelete("1");
				procedureVersion.setManagerByCreateBy(manager);
				procedureVersion.setCreateDate(new Timestamp(System
						.currentTimeMillis()));
				procedureVersionService.addProcedureVersion(procedureVersion);
			}else{
			//修改保存
				procedureVersionService.update(procedureVersion);
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
			procedureVersionService.removeAll(ids);
			return SUCCESS;
		} catch (DataAccessException e) {
			return ERROR;
		}
	}

	public ProcedureVersion getProcedureVersion() {
		return procedureVersion;
	}

	public void setProcedureVersion(ProcedureVersion procedureVersion) {
		this.procedureVersion = procedureVersion;
	}

	public ProcedureVersionService getProcedureVersionService() {
		return procedureVersionService;
	}

	public void setProcedureVersionService(ProcedureVersionService procedureVersionService) {
		this.procedureVersionService = procedureVersionService;
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

	public String getProcedureVersionId() {
		return procedureVersionId;
	}

	public void setProcedureVersionId(String procedureVersionId) {
		this.procedureVersionId = procedureVersionId;
	}

	public ProcedureMessageService getProcedureMessageService() {
		return procedureMessageService;
	}

	public void setProcedureMessageService(
			ProcedureMessageService procedureMessageService) {
		this.procedureMessageService = procedureMessageService;
	}

	public List<ProcedureMessage> getProcedureMessageList() {
		return procedureMessageList;
	}

	public void setProcedureMessageList(List<ProcedureMessage> procedureMessageList) {
		this.procedureMessageList = procedureMessageList;
	}

}
