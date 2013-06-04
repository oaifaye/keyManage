package com.keyManage.base;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * dao 基本基类方法接口
 * @author: sulifeng
 */
public interface HibernateGenericDAO<T> {
	
	//==============================================增========================================================
	/**
	 * 插入一条信息
	 * @param entity 要插入的对象
	 * */
	public void insert(T entity);
	
	//===============================================删==========================================================
	
	
	// ==============================================改==========================================================
	/**
	 * 修改一条信息
	 * @param entity 要修改的对象
	 * */
	public void update(T entity);
	
	/**
	 * 批量修改
	 * @param collection 需要批量修改的对象的集合
	 * */
	public void updateAll(final Collection<T> collection);
//	/**
//	 * 批量修改
//	 * @param ids 需要批量修改的对象的主键数组
//	 * */
//	public void updateAll(String[] ids);
//	
	//==============================================查========================================================
	/**
	 * 按主键查询对象
	 * @param id 主键（String）
	 * */
	public T findByPrimaryKey(String id);
	/**
	 * 按条件查询，返回一个对象
	 * @param params key为表中字段 value为对应字段的值
	 * */
	public T findUniqueByParams(Map<String, Object> params);
	/**
	 * 按条件查询，返回一个对象List
	 * @param params key为表中字段 value为对应字段的值
	 * */
	public List<T> findListByParams(Map<String, Object> params);
	/**
	 * 按条件查询，返回一个对象List
	 * @param params key为表中字段 value为对应字段的值
	 * @param likeParams key为表中字段 value为对应字段的值(模糊查询)
	 * */
	public List<T> findListByParams(Map<String, Object> params,Map<String, Object> likeParams);
	/**
	 * 按条件查询，返回一个对象List
	 * @param params key为表中字段 value为对应字段的值
	 * @param likeParams key为表中字段 value为对应字段的值(模糊查询)
	 * @param betweenParams key为表中字段 value为两个值组成的字符串，查询两个值之间的范围
	 * */
	public List<T> findListByParams(Map<String, Object> params,Map<String, Object> likeParams,Map<String, Timestamp[]> betweenParams,Map<String, String[]> inParams);
	/**
	 * 分页查询
	 * @param params key为要查询的字段 value为要查询的值
	 * @param currentPage 当前页
	 * @param pageSize 每页显示条数
	 * */
	public PaginationSupport findByPage(final Map<String, Object> params,
			final int currentPage, final int pageSize);
	
	public List<T> findByHql(String hql);
}
