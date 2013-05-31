package com.keyManage.action;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import com.keyManage.bean.Department;
import com.keyManage.bean.Manager;
import com.keyManage.service.department.DepartmentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DepartmentAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private Department department;
	private DepartmentService departmentService;
	private List<Department> departmentList;
	private String parentId;

	// 初始化
	public String init() {
//		if(kindOfKeyId!=null){
//			//kindOfKey=kindOfKeyService.findByPrimaryKey(kindOfKeyId);
//		}
//		if(currentPage<=1){
//			currentPage=1;
//		}
		try {
			Map<String, Object> params=new HashMap<String, Object>();
			params.put("isDelete", "1");
			params.put("level",1);
			departmentList=departmentService.findListByParams(params);
			return "init";
		} catch (DataAccessException e) {
			return ERROR;
		}
	}
	
	public String add(){
//		if(null==provinceId||("").equals(provinceId)){
//			//省级添加
//			department.setLevel(1);
//		}else{
//		
//		}str.substring(0,str.length()-1);
		//去掉parentId中所有空格与最后一个逗号
		parentId=department.getParentId().replace(" ", "");
		department.setParentId(parentId.substring(0,parentId.length()-1));
		//确定level
		int level = parentId.split(",").length+1;
		department.setLevel(level);
		Manager manager = (Manager)ActionContext.getContext().getSession().get("manager");
		department.setManagerByCreateBy(manager);
		department.setCreateDate(new Timestamp(System.currentTimeMillis()));
		department.setIsDelete("1");
		departmentService.addDepartment(department);
		return SUCCESS;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public List<Department> getDepartmentList() {
		return departmentList;
	}

	public void setDepartmentList(List<Department> departmentList) {
		this.departmentList = departmentList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}


}
