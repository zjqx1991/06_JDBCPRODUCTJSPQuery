/**
 * 
 */
package com.revanwang.product.template.handle.impl;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.revanwang.product.template.handle.IRevanResultHandle;

/**
 * @Desc 	
 * @author Revan Wang
 *
 * @Date Jul 4, 20197:36:28 PM
 */
public class RevanResultHandle<T> implements IRevanResultHandle<List<T>> {
	
	Class<T> clazz = null;
	

	public RevanResultHandle(Class<T> clazz) {
		this.clazz = clazz;
	}

	@Override
	public List<T> resultHandle(ResultSet resultSet) {
		List<T> list = new ArrayList<>();
		try {
			//1、内省机制
			BeanInfo info = Introspector.getBeanInfo(this.clazz, Object.class);
			PropertyDescriptor[] pds = info.getPropertyDescriptors();
			
			while (resultSet.next()) {
				//通过反射创建对象
				T objT = this.clazz.newInstance();
				for (PropertyDescriptor pd : pds) {
					String key = pd.getName();
					Object value = resultSet.getObject(key);
					pd.getWriteMethod().invoke(objT, value);
				}
				list.add(objT);
			}
		}  catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
