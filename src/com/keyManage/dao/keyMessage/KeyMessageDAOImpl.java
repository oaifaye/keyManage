package com.keyManage.dao.keyMessage;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

import com.keyManage.base.HibernateGenericDAOImpl;
import com.keyManage.bean.KeyMessage;
import com.keyManage.util.CountObject;

public class KeyMessageDAOImpl extends HibernateGenericDAOImpl<KeyMessage> implements
		KeyMessageDAO {
	@SuppressWarnings("unchecked")
	public List<CountObject> findNumByContainIds(String[] containIds){
		StringBuffer bufferHql=new StringBuffer("SELECT cast(ContainID as varchar(32)) AS ContainID, SUM(KeyNum) FROM KeyMessage WHERE ContainID IN( ");
		for(int i =0;i<containIds.length-1;i++){
			bufferHql.append("'");
			bufferHql.append(containIds[i]);
			bufferHql.append("',");
		}
		bufferHql.append("'");
		bufferHql.append(containIds[containIds.length-1]);
		bufferHql.append("')");
		bufferHql.append("group by ContainID");
		Session session = this.getSession();
		List<CountObject> list = new ArrayList<CountObject>();
		List<Object> listC =session.createSQLQuery(bufferHql.toString())
				.list();
		Object[] obj;
		//将listC封装成CountObject对象
				for (int i = 0; i < listC.size(); i++) {
					CountObject countObject=new CountObject();
					obj = (Object[]) listC.get(i);
					countObject.setItem(obj[0].toString());
					countObject.setNum((Integer) obj[1]);
					list.add(countObject);
				}

		return list;
	}
	
}
