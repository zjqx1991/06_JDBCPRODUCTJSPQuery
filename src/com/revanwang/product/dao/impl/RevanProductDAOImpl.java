/**
 * 
 */
package com.revanwang.product.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.revanwang.product.dao.IRevanProductDAO;
import com.revanwang.product.domain.RevanProduct;

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
		//贾琏欲执事
		Connection connection = null;
		PreparedStatement ps = null;
		
		try {
			//1、加载驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2、获取连接对象
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo", "root", "admin");
			ps = connection.prepareStatement(sql);
			
			ps.setString(1, product.getProductName());
			ps.setLong(2, product.getDir_id());
			ps.setBigDecimal(3, product.getSalePrice());
			ps.setString(4, product.getSupplier());
			ps.setString(5, product.getBrand());
			ps.setBigDecimal(6, product.getCutoff());
			ps.setBigDecimal(7, product.getCostPrice());
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				try {
					if (connection != null) {
						connection.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	@Override
	public void delete(Long id) {
		String sql = "DELETE FROM t_product WHERE id = ?";
		//贾琏欲执事
		//获取连接对象
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			//1、加载驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2、获取连接对象
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo", "root", "admin");
			//3、获取执行SQL语句对象
			ps = connection.prepareStatement(sql);
			ps.setLong(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				try {
					if (connection != null) {
						connection.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void update(RevanProduct product) {
		String sql = "UPDATE t_product SET productName = ?, dir_id = ?, salePrice = ?, supplier = ?, brand = ?, cutoff = ?, costPrice = ? WHERE id = ? ";
		//贾琏欲执事
		//获取连接对象
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			//1、加载驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2、获取连接对象
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo", "root", "admin");
			//3、获取执行SQL语句对象
			ps = connection.prepareStatement(sql);
			
			if (getProduct(product.getId()) != null) {
				ps.setString(1, product.getProductName());
				ps.setLong(2, product.getDir_id());
				ps.setBigDecimal(3, product.getSalePrice());
				ps.setString(4, product.getSupplier());
				ps.setString(5, product.getBrand());
				ps.setBigDecimal(6, product.getCutoff());
				ps.setBigDecimal(7, product.getCostPrice());
				ps.setLong(8, product.getId());
			}
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				try {
					if (connection != null) {
						connection.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	
	}

	@Override
	public RevanProduct getProduct(Long id) {
		String sql = "SELECT * FROM t_product WHERE id = ? ";
		//贾琏欲执事
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		try {
			//1、加载驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2、获取连接对象
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo", "root", "admin");
			//3、获取执行SQL语句对象
			ps = connection.prepareStatement(sql);
			ps.setLong(1, id);
			
			resultSet = ps.executeQuery();
			if (resultSet.next()) {
				RevanProduct product = new RevanProduct();
				product.setId(resultSet.getLong("id"));
				product.setProductName(resultSet.getString("productName"));
				product.setDir_id(resultSet.getLong("dir_id"));
				product.setSalePrice(resultSet.getBigDecimal("salePrice"));
				product.setSupplier(resultSet.getString("supplier"));
				product.setBrand(resultSet.getString("brand"));
				product.setCutoff(resultSet.getBigDecimal("cutoff"));
				product.setCostPrice(resultSet.getBigDecimal("costPrice"));
				return product;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				try {
					if (ps != null) {
						ps.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				finally {
					try {
						if (connection != null) {
							connection.close();
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return null;
	}

	@Override
	public List<RevanProduct> getList() {
		String sql = "SELECT * FROM t_product";
		List<RevanProduct> list = new ArrayList<RevanProduct>();
		//贾琏欲执事
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		try {
			//1、加载驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2、获取连接对象
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo", "root", "admin");
			//3、获取执行SQL语句对象
			ps = connection.prepareStatement(sql);
			
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				RevanProduct product = new RevanProduct();
				product.setId(resultSet.getLong("id"));
				product.setProductName(resultSet.getString("productName"));
				product.setDir_id(resultSet.getLong("dir_id"));
				product.setSalePrice(resultSet.getBigDecimal("salePrice"));
				product.setSupplier(resultSet.getString("supplier"));
				product.setBrand(resultSet.getString("brand"));
				product.setCutoff(resultSet.getBigDecimal("cutoff"));
				product.setCostPrice(resultSet.getBigDecimal("costPrice"));
				
				list.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				try {
					if (ps != null) {
						ps.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				finally {
					try {
						if (connection != null) {
							connection.close();
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return list;
	
	}

}
