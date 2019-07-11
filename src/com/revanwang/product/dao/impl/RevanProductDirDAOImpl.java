/**
 * 
 */
package com.revanwang.product.dao.impl;

import java.util.List;

import com.revanwang.product.dao.IRevanProductDirDAO;
import com.revanwang.product.domain.RevanProductDir;
import com.revanwang.product.template.RevanJdbcTemplate;
import com.revanwang.product.template.handle.impl.RevanResultHandle;

/**
 * @Desc 	
 * @author Revan Wang
 *
 * @Date Jul 9, 201912:25:11 PM
 */
public class RevanProductDirDAOImpl implements IRevanProductDirDAO {

	@Override
	public void save(RevanProductDir productDir) {
		String sql = "INSERT INTO t_product_dir (dir_id, dir_name) VALUES (?, ?)";
		RevanJdbcTemplate.executeUpdate(sql, productDir.getDir_id(), productDir.getDir_name());
	}

	@Override
	public void delete(Long id) {
		String sql = "DELETE FROM t_product_dir WHERE id=?";
		RevanJdbcTemplate.executeUpdate(sql, id);
	}

	@Override
	public void update(RevanProductDir productDir) {
		String sql = "UPDATE t_product_dir SET dir_id=?, dir_name=? WHERE id=?";
		RevanJdbcTemplate.executeUpdate(sql, productDir.getDir_id(), productDir.getDir_name(), productDir.getId());
	}

	@Override
	public RevanProductDir getProduct(Long id) {
		System.out.println("---------- 获取分类信息 ---------");
		String sql = "SELECT * FROM t_product_dir WHERE id = ?";
		List<RevanProductDir> list = RevanJdbcTemplate.executeQuery(sql, new RevanResultHandle<>(RevanProductDir.class), id);
		return list.size() == 1 ? list.get(0) : null;
	}

	@Override
	public List<RevanProductDir> getList() {
		String sql = "SELECT * FROM t_product_dir";
		List<RevanProductDir> list = RevanJdbcTemplate.executeQuery(sql, new RevanResultHandle<>(RevanProductDir.class));
		System.out.println(list.toArray());
		return list;
	}

}
