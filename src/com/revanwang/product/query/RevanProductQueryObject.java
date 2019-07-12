/**
 * 
 */
package com.revanwang.product.query;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/**
 * @Desc 	
 * @author Revan Wang
 *
 * @Date Jul 12, 201911:59:00 AM
 */
@Data
public class RevanProductQueryObject {
	private String productName;
	private BigDecimal minPrice;
	private BigDecimal maxPrice;
	//接收参数值
	private List<Object> paramsList = new ArrayList<>();

	/**
	 * @Desc	查询SQL语句
	 * @return
	 * @auther Revan Wang
	 * @Date Jul 12, 20191:57:34 PM
	 */
	public String querySQL() {
		//拼接SQL语句
		StringBuilder sql = new StringBuilder("SELECT * FROM t_product");
		//接收拼接的SQL语句
		List<String> sqlList = new ArrayList<>();

		//如果商品名称存在
		if (hasLength(productName)) {
			sqlList.add("productName Like ?");
			paramsList.add("%" + productName + "%");
		}

		if (minPrice != null) {
			sqlList.add("salePrice >= ?");
			paramsList.add(minPrice);
		}

		if (maxPrice != null) {
			sqlList.add("salePrice <= ?");
			paramsList.add(maxPrice);
		}

		//拼接SQL语句
		for (int i = 0; i < sqlList.size(); i++) {
			if (0 == i) {
				sql.append(" WHERE ");
			} else {
				sql.append(" AND ");
			}
			sql.append(sqlList.get(i));
		}
		return sql.toString();
	}
	
	/**
	 * @Desc	查询实参
	 * @return
	 * @auther Revan Wang
	 * @Date Jul 12, 20192:00:47 PM
	 */
	public List<Object>queryParams() {
		return paramsList;
	}
	
	private boolean hasLength(String string) {
		return string != null && string.length() > 0;
	}
}
