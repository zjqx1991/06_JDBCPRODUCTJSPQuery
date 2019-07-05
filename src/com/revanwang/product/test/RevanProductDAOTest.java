/**
 * 
 */
package com.revanwang.product.test;


import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.revanwang.product.dao.IRevanProductDAO;
import com.revanwang.product.dao.impl.RevanProductDAOImpl;
import com.revanwang.product.domain.RevanProduct;

/**
 * @Desc 	
 * @author Revan Wang
 *
 * @Date Jul 4, 20194:52:02 PM
 */
public class RevanProductDAOTest {

	IRevanProductDAO productDAO = new RevanProductDAOImpl();
	

	@Test
	public void testSave() {
		RevanProduct product = new RevanProduct();
		product.setProductName("樱桃-2");
		product.setDir_id(1L);
		product.setSalePrice(new BigDecimal(400.99));
		product.setSupplier("樱桃-2");
		product.setBrand("樱桃-2");
		product.setCutoff(new BigDecimal(0.85));
		product.setCostPrice(new BigDecimal(345.89));
		
		productDAO.save(product);
	}

	@Test
	public void testDelete() {
		productDAO.delete(7L);
	}
	
	@Test
	public void testUpdate() {
		RevanProduct product = new RevanProduct();
		product.setId(2L);
		product.setProductName("樱桃");
		product.setDir_id(1L);
		product.setSalePrice(new BigDecimal(400.99));
		product.setSupplier("樱桃");
		product.setBrand("樱桃");
		product.setCutoff(new BigDecimal(0.85));
		product.setCostPrice(new BigDecimal(345.89));
		
		productDAO.update(product);
	
	}

	
	@Test
	public void testGetProduct() {
		RevanProduct product = productDAO.getProduct(6L);
		System.out.println(product.toString());
	}

	
	@Test
	public void testGetList() {
		List<RevanProduct> list = productDAO.getList();
		Iterator<RevanProduct> it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next().toString());
		}
	}

}
