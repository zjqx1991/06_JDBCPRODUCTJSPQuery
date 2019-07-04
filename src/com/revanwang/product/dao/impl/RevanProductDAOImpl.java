/**
 * 
 */
package com.revanwang.product.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.revanwang.product.dao.IRevanProductDAO;
import com.revanwang.product.domain.RevanProduct;
import com.revanwang.product.jdbc.RevanJdbcUtils;
import com.revanwang.product.template.RevanJdbcTemplate;
import com.revanwang.product.template.handle.impl.RevanResultHandle;

/**
 * @Desc 	
 * @author Revan Wang
 *
 * @Date Jul 4, 20194:06:45 PM
 */
public class RevanProductDAOImpl implements IRevanProductDAO {

	@Override
	public void save(RevanProduct product) {
		String sql = "INSERT INTO t_product (productName, dir_id, salePrice, supplier, brand, cutoff, costPrice) "
								+ "VALUES (? , ?, ?, ?, ?, ?, ?)";
		RevanJdbcTemplate.executeUpdate(sql, product.getProductName(), product.getDir_id(), product.getSalePrice(), product.getSupplier(), product.getBrand(), product.getCutoff(), product.getCostPrice());
	}

	@Override
	public void delete(Long id) {
		String sql = "DELETE FROM t_product WHERE id = ?";
		RevanJdbcTemplate.executeUpdate(sql, id);
	}

	@Override
	public void update(RevanProduct product) {
		String sql = "UPDATE t_product SET productName = ?, dir_id = ?, salePrice = ?, supplier = ?, brand = ?, cutoff = ?, costPrice = ? WHERE id = ? ";
		RevanJdbcTemplate.executeUpdate(sql, product.getProductName(), product.getDir_id(), product.getSalePrice(), product.getSupplier(), product.getBrand(), product.getCutoff(), product.getCostPrice(), product.getId());
	}

	@Override
	public RevanProduct getProduct(Long id) {
		String sql = "SELECT * FROM t_product WHERE id = ? ";
		List<RevanProduct> list = RevanJdbcTemplate.executeQuery(sql, new RevanResultHandle<>(RevanProduct.class), id);
		return list.size() == 1 ? list.get(0) : null;
	}

	@Override
	public List<RevanProduct> getList() {
		String sql = "SELECT * FROM t_product";
		return RevanJdbcTemplate.executeQuery(sql, new RevanResultHandle<RevanProduct>(RevanProduct.class));
	}
}
