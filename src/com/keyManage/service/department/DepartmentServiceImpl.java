package com.keyManage.service.department;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.keyManage.base.PaginationSupport;
import com.keyManage.bean.Department;
import com.keyManage.dao.department.DepartmentDAO;

public class DepartmentServiceImpl implements DepartmentService {
	private DepartmentDAO departmentDAO;

	@Override
	public void addDepartment(Department department) {
		departmentDAO.insert(department);

	}
	
	public void update(Department department){
		departmentDAO.update(department);
	}
	
	@Override
	public void removeAll(String[] ids){
		Department department;
		for(String id:ids){
			department=departmentDAO.findByPrimaryKey(id);
			department.setIsDelete("0");
			departmentDAO.update(department);
		}
	}
	
	@Override
	public List<Department> findListByParams(Map<String, Object> params) {
		return  departmentDAO.findListByParams(params);
	}
	
	public Department findByPrimaryKey(String id){
		return departmentDAO.findByPrimaryKey(id);
	}
	
	public PaginationSupport findByPage(Map<String, Object> params,int currentPage, int pageSize){
		return departmentDAO.findByPage(params, currentPage, pageSize);
	}

	//dwr
	public Map<String, String> findByParentID(ArrayList<String> array){
		String parentId = array.get(0);
		String level = array.get(1);
		String isDelete = array.get(2);
		List<Department> departmentList = departmentDAO.findByParentID(parentId, level, isDelete);
		Map<String, String> departmentMap=new HashMap<String, String>();
		if(departmentList!=null){
			for(int i=0;i<departmentList.size();i++){
				departmentMap.put(departmentList.get(i).getId(), departmentList.get(i).getDepartmentName());
			}
		}
		return departmentMap;
	}
	
	public DepartmentDAO getDepartmentDAO() {
		return departmentDAO;
	}

	public void setDepartmentDAO(DepartmentDAO departmentDAO) {
		this.departmentDAO = departmentDAO;
	}
}
