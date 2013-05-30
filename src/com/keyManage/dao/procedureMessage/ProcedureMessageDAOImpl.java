package com.keyManage.dao.procedureMessage;

import java.util.List;

import com.keyManage.base.HibernateGenericDAOImpl;
import com.keyManage.bean.ProcedureMessage;

public class ProcedureMessageDAOImpl extends HibernateGenericDAOImpl<ProcedureMessage> implements ProcedureMessageDAO{

	public List<ProcedureMessage> findByIds(String[] array){
		StringBuffer buffer = new StringBuffer("FROM ProcedureMessage WHERE ID IN (");
		for(int i = 0;i<array.length-1;i++){
			buffer.append("'");
			buffer.append(array[i]);
			buffer.append("',");
		}
		buffer.append("'");
		buffer.append(array[array.length-1]);
		buffer.append("')");
		return super.findByHql(buffer.toString());
	}

}
