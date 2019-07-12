/**
 * 
 */
package com.revanwang.product.query;

import java.util.List;

/**
 * @Desc 	
 * @author Revan Wang
 *
 * @Date Jul 12, 20192:21:57 PM
 */
public interface IRevanQuery {

	/**
	 * @Desc	返回拼接的参数格式
	 * @return
	 * @auther Revan Wang
	 * @Date Jul 12, 20192:22:36 PM
	 */
	String querySQL();
	
	/**
	 * @Desc	返回查询参数
	 * @return
	 * @auther Revan Wang
	 * @Date Jul 12, 20192:00:47 PM
	 */
	List<Object>queryParams();
}
