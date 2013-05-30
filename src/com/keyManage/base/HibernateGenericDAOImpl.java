package com.keyManage.base;

import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.util.Assert;

/**
 * Dao基类实现类
 * @author: sulifeng
 */

public class HibernateGenericDAOImpl<T> extends HibernateDaoSupport implements
		HibernateGenericDAO<T> {
	protected final Log logger = LogFactory.getLog(this.getClass());
	protected Class<T> entityClass;
	protected String entityClassName;
	List<T> resultList = null;

	@SuppressWarnings("unchecked")
	public HibernateGenericDAOImpl() {
		try {
			Object genericClz = getClass().getGenericSuperclass();

			if (genericClz instanceof ParameterizedType) {
				entityClass = (Class<T>) ((ParameterizedType) genericClz)
						.getActualTypeArguments()[0];
				entityClassName = entityClass.getSimpleName();
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

	// ==============================================增========================================================
	public void insert(T entity) {
		try {
			Assert.notNull(entity);
			getHibernateTemplate().save(entity);
		} catch (DataAccessException e) {
			throw new DaoException("jdbc.error.code.Common.insert",
					new String[] { entityClass.getName() }, e);
		}
	}
	
	// ==============================================改==========================================================
	public void update(T entity){
		try {
			Assert.notNull(entity);
			getHibernateTemplate().update(entity);
		} catch (DataAccessException e) {
			throw new DaoException("jdbc.error.code.Common.update",
					new String[] { entityClass.getName() }, e);
		}
	}
	public void updateAll(final Collection<T> collection){
		if (collection == null || collection.isEmpty())
			return;
		for(T entity : collection){
			getHibernateTemplate().update(entity);
		}
	}
//	public void updateAll(String[] ids){
//		if(ids.length!=0){
//			for(String s : ids){
//				T entity=findByPrimaryKey(s);
//				getHibernateTemplate().update(entity);
//			}
//		}
//		
//	}

	// ==============================================查==========================================================

	public T findByPrimaryKey(String id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		return findUniqueByParams(params);
	}
	@SuppressWarnings("unchecked")
	public T findUniqueByParams(Map<String, Object> params) {
		try {
			Session session = this.getSession();
			Criteria crit = session.createCriteria(entityClass);
			// 获取params全部的key
			Set<String> keySet = params.keySet();
			Iterator<String> keyIterator = keySet.iterator();
			while (keyIterator.hasNext()) {
				String key = keyIterator.next();
				crit.add(Restrictions.eq(key, params.get(key)));
			}
			
			List<T> list = crit.addOrder( Property.forName("createDate").desc()) 
							.list();
			if (list == null || list.size() == 0) {
				return null;
			} else if (list.size() == 1) {
				return list.get(0);
			} else {
				throw new DaoException(
						"jdbc.error.code.Common.findUniqueByParams.notUique",
						new String[] { entityClass.getName(), params.toString() },
						null);
			}
		} catch (DataAccessException e) {
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findListByParams(Map<String, Object> params) {
		try {
			Session session = this.getSession();
			Criteria crit = session.createCriteria(entityClass);
			// 获取params全部的key
			Set<String> keySet = params.keySet();
			Iterator<String> keyIterator = keySet.iterator();
			while (keyIterator.hasNext()) {
				String key = keyIterator.next();
				crit.add(Restrictions.eq(key, params.get(key)));
			}
			
			List<T> list = crit.addOrder( Property.forName("createDate").desc()) 
							.list();
			if (list == null || list.size() == 0) {
				return null;
			} else if (list.size() > 1) {
				return list;
			} else {
				throw new DaoException(
						"jdbc.error.code.Common.findUniqueByParams.notUique",
						new String[] { entityClass.getName(), params.toString() },
						null);
			}
		} catch (DataAccessException e) {
			throw e;
		}
	}

	/**
	 * 分页查询
	 * @param params key为要查询的字段 value为要查询的值
	 * @param currentPage 当前页
	 * @param pageSize 每页显示条数
	 * */
	@SuppressWarnings("unchecked")
	public PaginationSupport findByPage(final Map<String, Object> params,
			final int currentPage, final int pageSize) {
		PaginationSupport list = null;
		try {
			// 通过一个HibernateCallback对象来执行查询
			list = (PaginationSupport) getHibernateTemplate().execute(
					new HibernateCallback() {
						// 实现HibernateCallback接口必须实现的方法
						public PaginationSupport doInHibernate(
								Session session) throws HibernateException,
								SQLException {
							Criteria crit = session.createCriteria(entityClass);
							// 获取params全部的key
							Set<String> keySet = params.keySet();
							Iterator<String> keyIterator = keySet.iterator();
							while (keyIterator.hasNext()) {
								String key = keyIterator.next();
								crit.add(Restrictions.eq(key, params.get(key)));
							}
							//总条数
							PaginationSupport ps=null;
								int totalCount = crit.list().size();
								List<T> result = crit
									.setFirstResult(
											(currentPage - 1) * pageSize)
									.setMaxResults(pageSize)
									.addOrder( Property.forName("createDate").desc())
									.list();
								ps = new PaginationSupport(
									result, totalCount, currentPage, pageSize);
							return ps;
						}
					});

		} catch (DataAccessException e) {
			throw new DaoException("jdbc.error.code.Common.findByPage",
					new String[] { entityClass.getName() }, e);
		}
		return list;
	}

	/**
	 * 分页查询
	 * @param hql sql查询的字符串
	 * @param currentPage 当前页
	 * @param pageSize 每页显示条数
	 * */
	@SuppressWarnings("unchecked")
	public PaginationSupport findByPage(final String hql,
			final int currentPage, final int pageSize) {
		PaginationSupport list = null;
		try {
			// 通过一个HibernateCallback对象来执行查询
			list = (PaginationSupport) getHibernateTemplate().execute(
					new HibernateCallback() {
						// 实现HibernateCallback接口必须实现的方法
						public PaginationSupport doInHibernate(
								Session session) throws HibernateException,
								SQLException {
							List<Object> result = session.createQuery(hql)
									.setFirstResult((currentPage-1)*pageSize)
									.setMaxResults(pageSize)
									.list();
							//总条数
							int totalCount=getHibernateTemplate().find(hql).size();
							PaginationSupport ps = new PaginationSupport(
									result, totalCount, currentPage, pageSize);
							return ps;
						}
					});

		} catch (DataAccessException e) {
			throw new DaoException("jdbc.error.code.Common.findByPage",
					new String[] { entityClass.getName() }, e);
		}
		return list;
	}
	
	//
	@SuppressWarnings("unchecked")
	public List<T> findByHql(String hql){
		return getHibernateTemplate().find(hql);
	}
	
}
