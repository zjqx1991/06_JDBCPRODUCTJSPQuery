/**
 * 
 */
package com.revanwang.product.template.handle;

import java.sql.ResultSet;

/**
 * @Desc 	
 * @author Revan Wang
 *
 * @Date Jul 4, 20197:35:14 PM
 */
public interface IRevanResultHandle<T> {

	T resultHandle(ResultSet resultSet);
}
