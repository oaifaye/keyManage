package com.keyManage.dao.kindOfKey;

import java.util.List;

import com.keyManage.base.HibernateGenericDAOImpl;
import com.keyManage.bean.KindOfKey;

public class KindOfKeyDAOImpl extends HibernateGenericDAOImpl<KindOfKey> implements KindOfKeyDAO{

	public List<KindOfKey> findByIds(String[] array){
		StringBuffer buffer = new StringBuffer("FROM KindOfKey WHERE ID IN (");
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
