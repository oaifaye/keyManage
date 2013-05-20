package com.keyManage.dao.manager;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.keyManage.base.HibernateGenericDAOImpl;
import com.keyManage.bean.Manager;

public class ManagerDAOImpl extends HibernateGenericDAOImpl<Manager> implements ManagerDAO {

	@Override
	@SuppressWarnings("unchecked")
	public Manager getLoginPerson(String userName, String password) {
		Session session = this.getSession();
		Criteria crit = session.createCriteria(Manager.class);
		crit.add(Restrictions.eq("userName", userName));
		crit.add(Restrictions.eq("password", password));
		List<Manager> list = crit.list();
		return list.size() > 0 ? list.get(0) : null;
	}

}
