package com.keyManage.action;

import java.io.IOException;
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
import com.keyManage.bean.Manager;
import com.keyManage.service.manager.ManagerService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ManagerAction extends ActionSupport {
	private String userName, password;
	private ManagerService managerService;
	private Manager managerMessages;
	private int currentPage;
	private PaginationSupport paginationSupport;
	private String managerId;

	/**
	 * 初始化人员列表
	 * */
	public String init() {
		if (managerId != null) {
			managerMessages = managerService.findByPrimaryKey(managerId);
		}
		if (currentPage <= 1) {
			currentPage = 1;
		}
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			paginationSupport = managerService.findByPage(params, currentPage,
					2);
			return "init";
		} catch (DataAccessException e) {
			return ERROR;
		}
	}

	/**
	 * 登陆验证
	 * */
	public String login() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userName", userName);
		params.put("password", password);
		Manager manager = managerService.getLoginPerson(params);
		if (manager == null) {
			addFieldError("error", "用户名或密码错");
			return "relogin";
		} else if (manager.getIsDelete().equals("0")) {
			addFieldError("error", "用户已停用");
			return "relogin";
		} else {
			ActionContext.getContext().getSession().put("manager", manager);
			ActionContext.getContext().getSession()
					.put("managerUserName", userName);
			return "loginSuccess";
		}
	}

	/** 初始化index.jsp */
	public String initIndex() {
		return "initIndex";
	}

	/** 增加用户 */
	public String add() {
		Manager managerSession = (Manager) ActionContext.getContext()
				.getSession().get("manager");
		Map<String, Object> params = new HashMap<String, Object>();
		try {
			/* 验证是否为管理员 */
			if (!managerSession.getRole().equals("0")) {
				HttpServletResponse response = ServletActionContext
						.getResponse();
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				out.print("<script>alert('您没有此权限!!');location='login.jsp';</script>");
				return null;
			}

			Assert.notNull(managerMessages);

			/* 新增保存 */
			System.out.println(managerMessages.getId());
			if (managerMessages.getId() == null || managerMessages.getId().equals("")) {
				/* 验证是否重复 */
				params.put("userName", managerMessages.getUserName().trim());
				List<Manager> managerTest = managerService
						.findListByParams(params);
				if (managerTest != null) {
					HttpServletResponse response = ServletActionContext
							.getResponse();
					response.setCharacterEncoding("UTF-8");
					response.setContentType("text/html; charset=utf-8");
					PrintWriter out = response.getWriter();
					out.print("<script>alert('此用户名已存在，请更名!!');location='manager_init';</script>");
					return null;
				}
				managerMessages.setIsDelete("1");
				managerMessages.setCreateDate(new Timestamp(System
						.currentTimeMillis()));
				managerMessages.setPassword("123456");
				managerService.addManager(managerMessages);
			} else {
				/* 修改保存 */
				/* 验证是否重复 */
				password=managerService.findByPrimaryKey(managerMessages.getId()).getPassword();
				params.put("userName", managerMessages.getUserName().trim());
				List<Manager> managerTest = managerService
						.findListByParams(params);
				if (managerTest != null)
					if (!managerTest.get(0).getId()
							.equals(managerMessages.getId())
							|| managerTest.size() > 1) {
						HttpServletResponse response = ServletActionContext
								.getResponse();
						response.setCharacterEncoding("UTF-8");
						response.setContentType("text/html; charset=utf-8");
						PrintWriter out = response.getWriter();
						out.print("<script>alert('此用户名已存在，请更名!!');location='manager_init';</script>");
						return null;
					}
				managerMessages.setPassword(password);
				managerMessages.setUpdateDate(new Timestamp(System
						.currentTimeMillis()));
				managerService.update(managerMessages);
			}

			return "addManager";
		} catch (Exception e) {
			return ERROR;
		}
	}

	// 逻辑删
	public String removeAll() {
		try {
			String[] ids = (String[]) ActionContext.getContext()
					.getParameters().get("ids");
			managerService.removeAll(ids);
			return "addManager";
		} catch (DataAccessException e) {
			return ERROR;
		}
	}

	// 恢复
	public String restore() {
		try {
			if (managerId != null) {
				managerMessages = managerService.findByPrimaryKey(managerId);
			}
			managerMessages.setIsDelete("1");
			managerService.update(managerMessages);
			return "addManager";
		} catch (DataAccessException e) {
			return ERROR;
		}
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ManagerService getManagerService() {
		return managerService;
	}

	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}

	public Manager getManagerMessages() {
		return managerMessages;
	}

	public void setManagerMessages(Manager managerMessages) {
		this.managerMessages = managerMessages;
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

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

}
