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
import com.keyManage.bean.Purpose;
import com.keyManage.bean.Manager;
import com.keyManage.service.purpose.PurposeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class PurposeAction extends ActionSupport {

	private Purpose purpose;
	private PurposeService purposeService;
	private int currentPage;
	private PaginationSupport paginationSupport;
	private String purposeId;

	// 初始化
	public String init() {
		if(purposeId!=null){
			purpose=purposeService.findByPrimaryKey(purposeId);
		}
		if(currentPage<=1){
			currentPage=1;
		}
		try {
			Map<String, Object> params=new HashMap<String, Object>();
			params.put("isDelete", "1");
			paginationSupport=purposeService.findByPage(params, currentPage, 2);
			return "init";
		} catch (DataAccessException e) {
			return ERROR;
		}
	}

	public String add() {
		Map<String, Object> params=new HashMap<String, Object>();
		try {
			
			if(purpose.getId()==null||purpose.getId().equals("")){
			//新建保存
				/*验证是否重复*/
				params.put("name", purpose.getName().trim());
				List<Purpose> purposeTest = purposeService.findListByParams(params);
				if(purposeTest!=null){
					HttpServletResponse response=ServletActionContext.getResponse();
					response.setCharacterEncoding("UTF-8");
					response.setContentType("text/html; charset=utf-8");
					PrintWriter out = response.getWriter();
					out.print("<script>alert('此锁用途已存在，请更名!!');location='purpose_init';</script>");
					return null;
				}
				Manager manager = (Manager)ActionContext.getContext().getSession().get("manager");
				Assert.notNull(purpose);
				purpose.setIsDelete("1");
				purpose.setManagerByCreateBy(manager);
				purpose.setCreateDate(new Timestamp(System
						.currentTimeMillis()));
				purposeService.addPurpose(purpose);
			}else{
			//修改保存
				/*验证是否重复*/
				params.put("name", purpose.getName().trim());
				List<Purpose> purposeTest = purposeService.findListByParams(params);
				if(purposeTest!=null)
					if (!purposeTest.get(0).getId().equals(purpose.getId())||purposeTest.size()>1){
					HttpServletResponse response=ServletActionContext.getResponse();
					response.setCharacterEncoding("UTF-8");
					response.setContentType("text/html; charset=utf-8");
					PrintWriter out = response.getWriter();
					out.print("<script>alert('此锁用途已存在，请更名!!');location='purpose_init';</script>");
					return null;
				}
				purposeService.update(purpose);
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
			purposeService.removeAll(ids);
			return SUCCESS;
		} catch (DataAccessException e) {
			return ERROR;
		}
	}

	public Purpose getPurpose() {
		return purpose;
	}

	public void setPurpose(Purpose purpose) {
		this.purpose = purpose;
	}


	public PurposeService getPurposeService() {
		return purposeService;
	}

	public void setPurposeService(
			PurposeService purposeService) {
		this.purposeService = purposeService;
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

	public String getPurposeId() {
		return purposeId;
	}

	public void setPurposeId(String purposeId) {
		this.purposeId = purposeId;
	}

}
