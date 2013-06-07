package com.keyManage.action;

import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
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
		Map<String, Object> params=new HashMap<String, Object>();
		try {
			
			if(procedureVersion.getId()==null||procedureVersion.getId().equals("")){
			//新建保存
				/*验证是否重复*/
				params.put("versionName", procedureVersion.getVersionName().trim());
				params.put("procedureMessage.id", procedureVersion.getProcedureMessage().getId());
				List<ProcedureVersion> procedureVersionTest = procedureVersionService.findListByParams(params);
				if(procedureVersionTest!=null){
					HttpServletResponse response=ServletActionContext.getResponse();
					response.setCharacterEncoding("UTF-8");
					response.setContentType("text/html; charset=utf-8");
					PrintWriter out = response.getWriter();
					out.print("<script>alert('此程序版本名称已存在，请更名!!');location='procedureVersion_init';</script>");
					return null;
				}
				Manager manager = (Manager)ActionContext.getContext().getSession().get("manager");
				Assert.notNull(procedureVersion);
				procedureVersion.setVersionName(procedureVersion.getVersionName());
				procedureVersion.setIsDelete("1");
				procedureVersion.setManagerByCreateBy(manager);
				procedureVersion.setCreateDate(new Timestamp(System
						.currentTimeMillis()));
				procedureVersionService.addProcedureVersion(procedureVersion);
			}else{
			//修改保存
				/*验证是否重复*/
				params.put("versionName", procedureVersion.getVersionName().trim());
				params.put("procedureMessage.id", procedureVersion.getProcedureMessage().getId());
				List<ProcedureVersion> procedureVersionTest = procedureVersionService.findListByParams(params);
				if(procedureVersionTest!=null)
					if (!procedureVersionTest.get(0).getId().equals(procedureVersion.getId())||procedureVersionTest.size()>1){
					HttpServletResponse response=ServletActionContext.getResponse();
					response.setCharacterEncoding("UTF-8");
					response.setContentType("text/html; charset=utf-8");
					PrintWriter out = response.getWriter();
					out.print("<script>alert('此程序版本名称已存在，请更名!!');location='procedureVersion_init';</script>");
					return null;
				}
				procedureVersionService.update(procedureVersion);
			}
			return SUCCESS;
		} catch (Exception e) {
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
