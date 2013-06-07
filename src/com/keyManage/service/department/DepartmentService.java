package com.keyManage.service.department;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.keyManage.base.PaginationSupport;
import com.keyManage.bean.Department;

public interface DepartmentService {

	public void addDepartment(Department department);
	public PaginationSupport findByPage(Map<String, Object> params,int currentPage, int pageSize);
	/**逻辑删*/
	public void update(Department department);
	public void removeAll(String[] ids);
	public Department findByPrimaryKey(String id);
	public List<Department> findListByParams(Map<String, Object> params);
	/**
	 * 按条件查询，返回一个对象List
	 * @param params key为表中字段 value为对应字段的值
	 * @param likeParams key为表中字段 value为对应字段的值(模糊查询)
	 * */
	public List<Department> findListByParams(Map<String, Object> params,Map<String, Object> likeParams);
	//dwr
	public Map<String, String> findByParentID(ArrayList<String> array);
	/**根据一个parentId计算其下所有单位的id(包括自己，放在最前)*/
	public String[] findListByParentId(String parentId,String isDelete);
	/**根据一个单位的id，计算其所有上级单位（包括自己，放在会后）*/
	public String[] findparentIdById(String id,String isDelete);
}
