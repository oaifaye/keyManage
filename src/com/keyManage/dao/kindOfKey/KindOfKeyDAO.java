package com.keyManage.dao.kindOfKey;

import java.util.List;

import com.keyManage.base.HibernateGenericDAO;
import com.keyManage.bean.KindOfKey;

public interface KindOfKeyDAO extends HibernateGenericDAO<KindOfKey> {
	public List<KindOfKey> findByIds(String[] array);
}
