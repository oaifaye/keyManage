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
import com.keyManage.bean.Department;
import com.keyManage.bean.KindOfKey;
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
	private String provinceId;
	private String cityId;
	private String districtId;

	// 初始化
	public String init() {
		/*三级单位的id,增加和修改后初始化三级下来菜单*/
		if(parentId!=null){
			String[] ids = parentId.split(",");
			if(ids.length>=1){
				provinceId=ids[0];
			}
			if(ids.length>=2){
				cityId=ids[1];
			}
			if(ids.length>=3){
				districtId=ids[2];
			}
		}
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("isDelete", "1");
			params.put("level", 1);
			departmentList = departmentService.findListByParams(params);
			return "init";
		} catch (DataAccessException e) {
			return ERROR;
		}
	}

	public String add() {
		Map<String, Object> params = new HashMap<String, Object>();
		Map<String, Object> likeParams = new HashMap<String, Object>();
		int level = 1;
		try {
			if(department.getParentId()!=null&&!department.getParentId().equals("")){
			// 去掉parentId中所有空格与最后一个逗号
				parentId = department.getParentId().replace(" ", "");
				parentId =parentId .substring(0, parentId.length() - 1);
				department.setParentId(parentId);
				level = parentId.split(",").length + 1;
			}
			
			
			/* 验证是否重复 */
			params.put("level", level);
			params.put("departmentName", department.getDepartmentName());
			if(level!=1){
				//不为1级单位的单位
				likeParams.put("parentId", parentId);
			}
			List<Department> departmentTest = departmentService.findListByParams(params, likeParams);
			if (departmentTest != null) {
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				out.print("<script>alert('此单位名称已存在，请更名!!');location='department_init';</script>");
				return null;
			}

			department.setLevel(level);
			Manager manager = (Manager) ActionContext.getContext().getSession()
					.get("manager");
			department.setManagerByCreateBy(manager);
			department.setCreateDate(new Timestamp(System.currentTimeMillis()));
			department.setIsDelete("1");
			departmentService.addDepartment(department);
			
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}

	public String updateDepartment() {
		Map<String, Object> params = new HashMap<String, Object>();
		Map<String, Object> likeParams = new HashMap<String, Object>();
		Department departmentLast = null;
		String likeParentId=null;

		try {
			/* 按单位的id查找单位 */
			parentId = department.getParentId().replace(" ", "");
			//parentId =parentId .substring(0, parentId.length() - 1);
			String[] parentIdArray = parentId.split(",");
			//取得单位id
			String departmentId = parentIdArray[parentIdArray.length - 1];
			departmentLast = departmentService.findByPrimaryKey(departmentId);

			params.put("level", departmentLast.getLevel());
			params.put("departmentName", department.getDepartmentName());
			if(departmentLast.getLevel()!=1){
				likeParentId=parentIdArray[parentIdArray.length - 2];
				likeParams.put("parentId", "%"+likeParentId+"%");
			}
			List<Department> departmentTest = departmentService.findListByParams(params, likeParams);
			// 
			if (departmentTest!=null) {
				HttpServletResponse response = ServletActionContext
						.getResponse();
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = null;

				out = response.getWriter();

				out.print("<script>alert('此单位名称已存在，请更名!!');location='department_init';</script>");
				return null;
			}
			
			departmentLast.setDepartmentName(department.getDepartmentName());
			departmentService.update(departmentLast);
			return SUCCESS;
		} catch (IOException e) {
			return ERROR;
		}
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

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getDistrictId() {
		return districtId;
	}

	public void setDistrictId(String districtId) {
		this.districtId = districtId;
	}

}
