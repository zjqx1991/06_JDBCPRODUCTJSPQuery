/**
 * 
 */
package com.revanwang.product.template;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.revanwang.product.jdbc.RevanJdbcUtils;
import com.revanwang.product.template.handle.IRevanResultHandle;

/**
 * @Desc 	
 * @author Revan Wang
 *
 * @Date Jul 4, 20197:18:33 PM
 */
public class RevanJdbcTemplate {

	//私有化构造器
	private RevanJdbcTemplate() {
	}

	public static int executeUpdate(String sql, Object... args) {
		//贾琏欲执事
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			//2、获取连接对象
			connection = RevanJdbcUtils.getConnection();
			ps = connection.prepareStatement(sql);

			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			RevanJdbcUtils.close(connection, ps, null);
		}
		return 0;
	}

	public static <T> T executeQuery(String sql, IRevanResultHandle<T> handle, Object... args) {
		//贾琏欲执事
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			//2、获取连接对象
			connection = RevanJdbcUtils.getConnection();
			ps = connection.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}
			
			return handle.resultHandle(ps.executeQuery());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			RevanJdbcUtils.close(connection, ps, null);
		}
		return null;
	}
}
