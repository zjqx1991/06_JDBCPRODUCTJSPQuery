/**
 * 
 */
package com.revanwang.product.dao;

import java.math.BigDecimal;
import java.util.List;

import com.revanwang.product.domain.RevanProduct;
import com.revanwang.product.domain.RevanProductInfo;
import com.revanwang.product.page.RevanPageResult;
import com.revanwang.product.query.RevanProductQueryObject;

/**
 * @Desc 	
 * @author Revan Wang
 *
 * @Date Jul 4, 20194:06:02 PM
 */
public interface IRevanProductDAO {

	/**
	 * @Desc 保存商品
	 * @param product
	 * @auther Revan Wang
	 * @Date Jul 4, 20194:07:15 PM
	 */
	void save(RevanProduct product);
	
	/**
	 * @Desc 删除指定id商品
	 * @param id 商品id
	 * @auther Revan Wang
	 * @Date Jul 4, 20194:07:46 PM
	 */
	void delete(Long id);
	
	/**
	 * @Desc 修改商品
	 * @param product
	 * @auther Revan Wang
	 * @Date Jul 4, 20194:08:53 PM
	 */
	void update(RevanProduct product);
	
	/**
	 * @Desc 查询指定id的商品
	 * @param id 查询商品的id
	 * @return
	 * @auther Revan Wang
	 * @Date Jul 4, 20194:09:49 PM
	 */
	RevanProduct getProduct(Long id);
	
	/**
	 * @Desc	查询指定id的商品详情
	 * @param id
	 * @return
	 * @auther Revan Wang
	 * @Date Jul 11, 201910:20:54 AM
	 */
	RevanProductInfo getProductInfo(Long id);
	
	/**
	 * @Desc 获取所有商品
	 * @return
	 * @auther Revan Wang
	 * @Date Jul 4, 20194:10:37 PM
	 */
	List<RevanProduct> getList();
	
	/**
	 * @Desc	获取详细的商品信息
	 * @return
	 * @auther Revan Wang
	 * @Date Jul 11, 20199:48:38 AM
	 */
	List<RevanProductInfo>getProductList();
	

	/**
	 * @Desc				查询列表
	 * @param name			商品名称
	 * @param minPrice		最低价格
	 * @param maxPrice		最高价格
	 * @return
	 * @auther Revan Wang
	 * @Date Jul 12, 201911:14:35 AM
	 */
	List<RevanProductInfo>query(String name, BigDecimal minPrice, BigDecimal maxPrice);
	

	/**
	 * @Desc				查询列表(请求参数封装成对象)
	 * @param name			商品名称
	 * @param minPrice		最低价格
	 * @param maxPrice		最高价格
	 * @return
	 * @auther Revan Wang
	 * @Date Jul 12, 201911:14:35 AM
	 */
	List<RevanProductInfo>query2(RevanProductQueryObject queryObject);

	/**
	 * @Desc				查询列表(请求参数封装成对象)优化代码
	 * @param name			商品名称
	 * @param minPrice		最低价格
	 * @param maxPrice		最高价格
	 * @return
	 * @auther Revan Wang
	 * @Date Jul 12, 201911:14:35 AM
	 */
	List<RevanProductInfo>query3(RevanProductQueryObject queryObject);
	

	/**
	 * @Desc				查询列表(把请求SQL语句 和 SQL参数封装到 请求对象中)
	 * @param name			商品名称
	 * @param minPrice		最低价格
	 * @param maxPrice		最高价格
	 * @return
	 * @auther Revan Wang
	 * @Date Jul 12, 201911:14:35 AM
	 */
	List<RevanProductInfo>query4(RevanProductQueryObject queryObject);
	

	/**
	 * @Desc				抽取查询对象模板
	 * @param name			商品名称
	 * @param minPrice		最低价格
	 * @param maxPrice		最高价格
	 * @return
	 * @auther Revan Wang
	 * @Date Jul 12, 201911:14:35 AM
	 */
	List<RevanProductInfo>query5(RevanProductQueryObject queryObject);
	
	/**
	 * @Desc				分页查询
	 * @param currentPage	查询页
	 * @param pageSize		每页个数
	 * @return
	 * @auther Revan Wang
	 * @Date Jul 16, 201911:48:11 AM
	 */
	RevanPageResult queryPage(RevanProductQueryObject queryObject);
}
