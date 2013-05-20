package com.keyManage.base;

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
	
	
	//==============================================查========================================================
	/**
	 * 按条件查询，返回一个对象
	 * @param params key为表中字段 value为对应字段的值
	 * */
	public T findUniqueByParams(Map<String, Object> params);
	/**
	 * 分页查询
	 * @param params key为要查询的字段 value为要查询的值
	 * @param currentPage 当前页
	 * @param pageSize 每页显示条数
	 * */
	public PaginationSupport findByPage(final Map<String, Object> params,
			final int currentPage, final int pageSize);
}
