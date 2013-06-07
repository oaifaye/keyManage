package com.keyManage.dao.department;

import java.util.List;
import java.util.Map;

import com.keyManage.base.HibernateGenericDAO;
import com.keyManage.bean.Department;

public interface DepartmentDAO extends HibernateGenericDAO<Department> {
	
	/**dwr*/
	public List<Department> findByParentID(String parentId ,String level,String isDelete);
	
}
