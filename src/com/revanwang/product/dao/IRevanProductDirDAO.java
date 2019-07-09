/**
 * 
 */
package com.revanwang.product.dao;

import java.util.List;

import com.revanwang.product.domain.RevanProductDir;

/**
 * @Desc 	
 * @author Revan Wang
 *
 * @Date Jul 9, 201912:19:03 PM
 */
public interface IRevanProductDirDAO {

	/**
	 * @Desc 保存商品类型
	 * @param product
	 * @auther Revan Wang
	 * @Date Jul 4, 20194:07:15 PM
	 */
	void save(RevanProductDir productDir);
	
	/**
	 * @Desc 删除指定商品类型id商品
	 * @param id 商品id
	 * @auther Revan Wang
	 * @Date Jul 4, 20194:07:46 PM
	 */
	void delete(Long id);
	
	/**
	 * @Desc 修改商品类型
	 * @param product
	 * @auther Revan Wang
	 * @Date Jul 4, 20194:08:53 PM
	 */
	void update(RevanProductDir productDir);
	
	/**
	 * @Desc 查询指定商品类型id
	 * @param id 查询商品的id
	 * @return
	 * @auther Revan Wang
	 * @Date Jul 4, 20194:09:49 PM
	 */
	RevanProductDir getProduct(Long id);
	
	/**
	 * @Desc 获取所有商品类型
	 * @return
	 * @auther Revan Wang
	 * @Date Jul 4, 20194:10:37 PM
	 */
	List<RevanProductDir> getList();
}
