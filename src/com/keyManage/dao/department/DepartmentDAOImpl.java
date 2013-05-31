package com.keyManage.dao.department;

import java.util.List;

import com.keyManage.base.HibernateGenericDAOImpl;
import com.keyManage.bean.Department;

public class DepartmentDAOImpl extends HibernateGenericDAOImpl<Department> implements DepartmentDAO{

	public List<Department> findByParentID(String parentId ,String level,String isDelete){
		String hql = "FROM Department WHERE ParentID LIKE '%"+parentId+"%' AND Level ="+level+" AND IsDelete="+isDelete;
		List<Department> departmentList = super.findByHql(hql);
		return departmentList;
	}

}
