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
	//dwr
	public Map<String, String> findByParentID(ArrayList<String> array);
}
