package com.keyManage.dao.procedureMessage;

import java.util.List;

import com.keyManage.base.HibernateGenericDAO;
import com.keyManage.bean.ProcedureMessage;

public interface ProcedureMessageDAO extends HibernateGenericDAO<ProcedureMessage> {
	public List<ProcedureMessage> findByIds(String[] array);
}
