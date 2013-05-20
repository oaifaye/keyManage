package com.keyManage.service.contain;

import com.keyManage.bean.Contain;
import com.keyManage.dao.contain.ContainDAO;

public class ContainServiceImpl implements ContainService {
	
	private ContainDAO containDAO;

	@Override
	public void addContain(Contain contain) {
		containDAO.insert(contain);
	}
	
	

	public ContainDAO getContainDAO() {
		return containDAO;
	}

	public void setContainDAO(ContainDAO containDAO) {
		this.containDAO = containDAO;
	}

	
}
