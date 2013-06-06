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
import com.keyManage.bean.ExpressType;
import com.keyManage.bean.Manager;
import com.keyManage.bean.Purpose;
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
		Map<String, Object> params=new HashMap<String, Object>();
		try {
			
			if(expressType.getId()==null||expressType.getId().equals("")){
			//新建保存
				/*验证是否重复*/
				params.put("expressTypeName", expressType.getExpressTypeName().trim());
				List<ExpressType> expressTypeTest = expressTypeService.findListByParams(params);
				if(expressTypeTest!=null){
					HttpServletResponse response=ServletActionContext.getResponse();
					response.setCharacterEncoding("UTF-8");
					response.setContentType("text/html; charset=utf-8");
					PrintWriter out = response.getWriter();
					out.print("<script>alert('此送锁方式已存在，请更名!!');location='expressType_init';</script>");
					return null;
				}
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
		} catch (Exception e) {
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
