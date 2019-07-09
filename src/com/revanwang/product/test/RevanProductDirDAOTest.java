/**
 * 
 */
package com.revanwang.product.test;


import java.util.Iterator;
import java.util.List;
import org.junit.Test;
import com.revanwang.product.dao.IRevanProductDirDAO;
import com.revanwang.product.dao.impl.RevanProductDirDAOImpl;
import com.revanwang.product.domain.RevanProductDir;

/**
 * @Desc 	
 * @author Revan Wang
 *
 * @Date Jul 4, 20194:52:02 PM
 */
public class RevanProductDirDAOTest {

	IRevanProductDirDAO dirDAO = new RevanProductDirDAOImpl();
	

	@Test
	public void testSave() {
		RevanProductDir dir = new RevanProductDir();
		dir.setDir_id(5L);
		dir.setDir_name("有线键盘");
		dirDAO.save(dir);
	}

	@Test
	public void testDelete() {
		dirDAO.delete(7L);
	}
	
	@Test
	public void testUpdate() {
		RevanProductDir dir = new RevanProductDir();
		dir.setId(6L);
		dir.setDir_id(6L);
		dir.setDir_name("无线键盘");
		dirDAO.update(dir);
	}

	
	@Test
	public void testGetProduct() {
		RevanProductDir dir = dirDAO.getProduct(6L);
		System.out.println(dir.toString());
	}

	
	@Test
	public void testGetList() {
		List<RevanProductDir> list = dirDAO.getList();
		Iterator<RevanProductDir> it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next().toString());
		}
	}

}
