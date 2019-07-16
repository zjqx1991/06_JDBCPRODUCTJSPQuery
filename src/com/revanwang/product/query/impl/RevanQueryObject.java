/**
 * 
 */
package com.revanwang.product.query.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.revanwang.product.query.IRevanQuery;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @Desc 	查询对象父类
 * @author Revan Wang
 *
 * @Date Jul 12, 20192:25:07 PM
 */
abstract public class RevanQueryObject implements IRevanQuery {
	//当前页
	private Integer currentPage = 1;
	//每页个数
	private Integer pageSize = 3;
	//接收参数值
	private List<Object> paramsList = new ArrayList<>();
	//接收拼接的SQL语句
	private List<String> conditionList = new ArrayList<>();
	

	/**
	 * @Desc 用于添加查询SQL语句的 参数
	 * @auther Revan Wang
	 * @Date Jul 12, 20193:04:09 PM
	 */
	abstract public void customQuery();
	
	/**
	 * @Desc			子类重写，用于添加查询条件
	 * @param condition	
	 * @param param
	 * @auther Revan Wang
	 * @Date Jul 12, 20192:43:08 PM
	 */
	protected void addQuery(String condition, Object... param) {
		//添加SQL条件
		this.conditionList.add("(" + condition + ")");
		this.paramsList.addAll(Arrays.asList(param));
	}
	
	protected boolean hasLength(String string) {
		return string != null && string.length() > 0;
	}

	@Override
	public String querySQL() {
		//拼接SQL语句
		StringBuilder sql = new StringBuilder(200);
		//用于子类重写
		this.customQuery();
		//拼接SQL语句
		for (int i = 0; i < conditionList.size(); i++) {
			if (0 == i) {
				sql.append(" WHERE ");
			} else {
				sql.append(" AND ");
			}
			sql.append(conditionList.get(i));
		}
		System.out.println("SQL查询语句" + sql.toString());
		return sql.toString();
	}

	@Override
	public List<Object> queryParams() {
		System.out.println("SQL查询参数" + this.paramsList.toString());
		return this.paramsList;
	}

	/**
	 * @return the currentPage
	 */
	public Integer getCurrentPage() {
		return currentPage;
	}

	/**
	 * @param currentPage the currentPage to set
	 */
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * @return the pageSize
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

}
