package com.keyManage.dao.contain;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.keyManage.base.HibernateGenericDAOImpl;
import com.keyManage.bean.Contain;
import com.keyManage.util.CountObject;

public class ContainDAOImpl extends HibernateGenericDAOImpl<Contain> implements
		ContainDAO {

	@SuppressWarnings("unchecked")
	public List<CountObject> findCountByKindOfKeyID(String saveOrTake) {
		String hql = "SELECT cast(KindOfKeyID as varchar(32)) AS KindOfKeyID ,SUM(KeyNum) FROM Contain WHERE SaveOrTake=? GROUP BY KindOfKeyID ORDER BY SUM(KeyNum)";
		Session session = this.getSession();
		List<CountObject> list = new ArrayList<CountObject>();
		List<Object> listC =session.createSQLQuery(hql).setString(0, saveOrTake)
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
