/**
 * 
 */
package com.revanwang.product.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;


/**
 * @Desc 	
 * @author Revan Wang
 *
 * @Date Jul 4, 20196:54:17 PM
 */
public class RevanJdbcUtils {
	
	private static DataSource dataSource = null;
	
	//私有化构造器
	private RevanJdbcUtils() {}
	
	static {
		ClassLoader clazzLoader = Thread.currentThread().getContextClassLoader();
		InputStream inputStream = clazzLoader.getResourceAsStream("db.properties");

		Properties pps = new Properties();
		
		try {
			pps.load(inputStream);
			//使用连接池
			dataSource = DruidDataSourceFactory.createDataSource(pps);
			
			//加载驱动
			/*Class.forName(p.getProperty("driverClassName"));
			connection = DriverManager.getConnection(
					p.getProperty("url"), 
					p.getProperty("username"), 
					p.getProperty("password")
					);*/
			
		} catch (Exception e) {
			throw new RuntimeException("加载classpath配置文件失败");
		}
		
	}
	
	/**
	 * @Desc 获取连接对象
	 * @return
	 * @auther Revan Wang
	 * @Date Jul 4, 20197:06:59 PM
	 */
	public static Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void close(Connection connection, Statement ps, ResultSet resultSet) {
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
	
}
