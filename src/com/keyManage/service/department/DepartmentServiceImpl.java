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
	
	/**
	 * 按条件查询，返回一个对象List
	 * @param params key为表中字段 value为对应字段的值
	 * @param likeParams key为表中字段 value为对应字段的值(模糊查询)
	 * */
	@Override
	public List<Department> findListByParams(Map<String, Object> params,
			Map<String, Object> likeParams) {
		return departmentDAO.findListByParams(params, likeParams);
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
	
	@Override
	public String[] findListByParentId(String parentId,String isDelete) {
		List<Department> departmentList = departmentDAO.findByParentID(parentId, null, isDelete);
		String[] ids =new String[departmentList.size()+1];
		for(int i = 1;i<departmentList.size()+1;i++){
			ids[i]=departmentList.get(i).getId();
		}
		ids[0]=parentId;
		return ids;
	}
	
	public String[] findparentIdById(String id,String isDelete){
		Department department = departmentDAO.findByPrimaryKey(id);
		String[] ids=null;
		String parentId = department.getParentId();
		if(parentId!=null&&!parentId.equals("")){
			String[] parentIdArray = parentId.split(",");
			ids = new String[parentIdArray.length+1];
			for(int i = 0;i<parentIdArray.length;i++){
				ids[i]=parentIdArray[i];
			}
			ids[parentIdArray.length]=id;
		}else{
			ids=new String[1];
			ids[0]=id;
		}
		return ids;
	}
	
	
	public DepartmentDAO getDepartmentDAO() {
		return departmentDAO;
	}

	public void setDepartmentDAO(DepartmentDAO departmentDAO) {
		this.departmentDAO = departmentDAO;
	}

	
	
}
