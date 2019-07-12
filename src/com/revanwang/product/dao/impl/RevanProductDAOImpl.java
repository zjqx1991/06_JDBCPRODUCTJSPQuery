/**
 * 
 */
package com.revanwang.product.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.revanwang.product.dao.IRevanProductDAO;
import com.revanwang.product.dao.IRevanProductDirDAO;
import com.revanwang.product.domain.RevanProduct;
import com.revanwang.product.domain.RevanProductDir;
import com.revanwang.product.domain.RevanProductInfo;
import com.revanwang.product.template.RevanJdbcTemplate;
import com.revanwang.product.template.handle.IRevanResultHandle;
import com.revanwang.product.template.handle.impl.RevanResultHandle;

/**
 * @Desc 	
 * @author Revan Wang
 *
 * @Date Jul 4, 20194:06:45 PM
 */
public class RevanProductDAOImpl implements IRevanProductDAO {
	private IRevanProductDirDAO dirDAO = new RevanProductDirDAOImpl();
	//请求分类信息缓存
	private Map<Long, RevanProductDir> productDirMap = new HashMap<Long, RevanProductDir>();
	
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
	

	@Override
	public List<RevanProductInfo> getProductList() {
		String sql = "SELECT * FROM t_product";
		
		List<RevanProductInfo> productInfos = new ArrayList<>();
		List<RevanProduct> proList = RevanJdbcTemplate.executeQuery(sql, new RevanResultHandle<RevanProduct>(RevanProduct.class));
		for (RevanProduct pd : proList) {
			//分类id
			Long dir_id = pd.getDir_id();
			//获取缓存对象
			RevanProductDir productDir = productDirMap.get(dir_id);
			if (productDir == null) {
				productDir = dirDAO.getProduct(dir_id);
				//存储到缓存中
				productDirMap.put(dir_id, productDir);
			}
			//商品详情
			RevanProductInfo productInfo = new RevanProductInfo();
			productInfo.setProduct(pd);
			productInfo.setProductDir(productDir);
			productInfos.add(productInfo);
		}
		return productInfos;
	}

	@Override
	public RevanProductInfo getProductInfo(Long id) {
		String sql = "SELECT * FROM t_product WHERE id = ? ";
		List<RevanProduct> list = RevanJdbcTemplate.executeQuery(sql, new RevanResultHandle<>(RevanProduct.class), id);
		if (list.size() != 1) {
			return null;
		}
		RevanProduct product = list.get(0);
		Long dir_id = product.getDir_id();
		RevanProductDir productDir = productDirMap.get(dir_id);
		if (productDir == null) {
			productDir = dirDAO.getProduct(dir_id);
			//存入缓存
			productDirMap.put(dir_id, productDir);
		}
		RevanProductInfo productInfo = new RevanProductInfo();
		productInfo.setProduct(product);
		productInfo.setProductDir(productDir);
		return productInfo;
	}
	
}
