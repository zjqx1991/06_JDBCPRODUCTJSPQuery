/**
 * 
 */
package com.revanwang.product.dao;

import java.util.List;

import com.revanwang.product.domain.RevanProduct;

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
	 * @Desc 获取所有商品
	 * @return
	 * @auther Revan Wang
	 * @Date Jul 4, 20194:10:37 PM
	 */
	List<RevanProduct> getList();
}
