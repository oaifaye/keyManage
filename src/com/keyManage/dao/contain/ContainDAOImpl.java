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
	
	@SuppressWarnings("unchecked")
	public List<CountObject> findCountLotNumberByKindOfKeyID(String saveOrTake,String kindOfKeyID) {
		String hql = "SELECT LotNumber , Remark, SUM(KeyNum) FROM Contain WHERE SaveOrTake=? AND KindOfKeyID=? GROUP BY LotNumber , Remark ORDER BY SUM(KeyNum)";
		Session session = this.getSession();
		List<CountObject> list = new ArrayList<CountObject>();
		List<Object> listC =session.createSQLQuery(hql)
								.setString(0, saveOrTake)
								.setString(1, kindOfKeyID)
								.list();
		Object[] obj;
		//将listC封装成CountObject对象
		for (int i = 0; i < listC.size(); i++) {
			CountObject countObject=new CountObject();
			obj = (Object[]) listC.get(i);
			countObject.setItem(obj[0].toString());
			if(obj[1]!=null&&!obj[1].equals("")){
				countObject.setRemark(obj[1].toString());
			}
			countObject.setNum((Integer) obj[2]);
			list.add(countObject);
		}

		return list;
	}
	
	public void insertAllContain(List<Contain> ContainList){
		for(Contain contain:ContainList){
			super.insert(contain);
		}
	}
	
	@SuppressWarnings("unchecked")
	public Integer findCountNumByKeyAskID(String keyAskID,String isDelete) {
		Integer num = null;
		String hql = "SELECT SUM(KeyNum) FROM Contain WHERE KeyAskID=? AND IsDelete=? GROUP BY KeyAskID ORDER BY SUM(KeyNum)";
		Session session = this.getSession();
		List<Object> list =session.createSQLQuery(hql)
								.setString(0, keyAskID)
								.setString(1, isDelete)
								.list();
		if(list.size()>0){
			num = (Integer)list.get(0);
		}
		
		return num;
	}

}
