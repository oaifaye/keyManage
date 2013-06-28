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
import com.keyManage.bean.KindOfKey;
import com.keyManage.bean.ProcedureMessage;
import com.keyManage.bean.Manager;
import com.keyManage.service.procedureMessage.ProcedureMessageService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ProcedureMessageAction extends ActionSupport {

	private ProcedureMessage procedureMessage;
	private ProcedureMessageService procedureMessageService;
	private int currentPage;
	private PaginationSupport paginationSupport;
	private String procedureMessageId;

	// 初始化
	public String init() {
		if(procedureMessageId!=null){
			procedureMessage=procedureMessageService.findByPrimaryKey(procedureMessageId);
		}
		if(currentPage<=1){
			currentPage=1;
		}
		try {
			Map<String, Object> params=new HashMap<String, Object>();
			params.put("isDelete", "1");
			paginationSupport=procedureMessageService.findByPage(params, currentPage, 10);
			return "init";
		} catch (DataAccessException e) {
			return ERROR;
		}
	}

	public String add() {
		Map<String, Object> params=new HashMap<String, Object>();
		try {
			
			if(procedureMessage.getId()==null||procedureMessage.getId().equals("")){
			//新建保存
				/*验证是否重复*/
				params.put("procedureName", procedureMessage.getProcedureName().trim());
				List<ProcedureMessage> procedureMessageTest = procedureMessageService.findListByParams(params);
				if(procedureMessageTest!=null){
					HttpServletResponse response=ServletActionContext.getResponse();
					response.setCharacterEncoding("UTF-8");
					response.setContentType("text/html; charset=utf-8");
					PrintWriter out = response.getWriter();
					out.print("<script>alert('此程序名称已存在，请更名!!');location='procedureMessage_init';</script>");
					return null;
				}
				Manager manager = (Manager)ActionContext.getContext().getSession().get("manager");
				Assert.notNull(procedureMessage);
				procedureMessage.setIsDelete("1");
				procedureMessage.setManagerByCreateBy(manager);
				procedureMessage.setCreateDate(new Timestamp(System
						.currentTimeMillis()));
				procedureMessageService.addProcedureMessage(procedureMessage);
			}else{
			//修改保存
				/*验证是否重复*/
				params.put("procedureName", procedureMessage.getProcedureName().trim());
				List<ProcedureMessage> procedureMessageTest = procedureMessageService.findListByParams(params);
				if(procedureMessageTest!=null)
					if (!procedureMessageTest.get(0).getId().equals(procedureMessage.getId())||procedureMessageTest.size()>1){
					HttpServletResponse response=ServletActionContext.getResponse();
					response.setCharacterEncoding("UTF-8");
					response.setContentType("text/html; charset=utf-8");
					PrintWriter out = response.getWriter();
					out.print("<script>alert('此程序名称已存在，请更名!!');location='procedureMessage_init';</script>");
					return null;
				}
				procedureMessageService.update(procedureMessage);
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
			procedureMessageService.removeAll(ids);
			return SUCCESS;
		} catch (DataAccessException e) {
			return ERROR;
		}
	}

	public ProcedureMessage getProcedureMessage() {
		return procedureMessage;
	}

	public void setProcedureMessage(ProcedureMessage procedureMessage) {
		this.procedureMessage = procedureMessage;
	}


	public ProcedureMessageService getProcedureMessageService() {
		return procedureMessageService;
	}

	public void setProcedureMessageService(
			ProcedureMessageService procedureMessageService) {
		this.procedureMessageService = procedureMessageService;
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

	public String getProcedureMessageId() {
		return procedureMessageId;
	}

	public void setProcedureMessageId(String procedureMessageId) {
		this.procedureMessageId = procedureMessageId;
	}

}
