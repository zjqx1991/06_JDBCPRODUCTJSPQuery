/**
 * 
 */
package com.revanwang.web;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revanwang.product.dao.IRevanProductDAO;
import com.revanwang.product.dao.impl.RevanProductDAOImpl;
import com.revanwang.product.domain.RevanProduct;

/**
 * @Desc 	
 * @author Revan Wang
 *
 * @Date Jul 4, 20198:30:12 PM
 */
@WebServlet("/product")
public class ProductServlet extends HttpServlet {

	IRevanProductDAO productDAO = new RevanProductDAOImpl();
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		//1、获取请求参数
		//2、处理业务
		String cmd = req.getParameter("cmd");
		//3、跳转页面
		System.out.print("请求参数："+cmd);
		if (cmd != null) {
			switch (cmd) {
			case "save":
				save(req, resp);
				break;
			case "delete":
				delete(req, resp);
				break;
			case "edit":
				update(req, resp);
				break;

			default:
				list(req, resp);
				break;
			}
		}
		else {
			list(req, resp);
		}
	}
	
	protected void save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1、获取请求参数
		String id = req.getParameter("id");
		String productName = req.getParameter("productName");
		String dir_id = req.getParameter("dir_id");
		String salePrice = req.getParameter("salePrice");
		String supplier = req.getParameter("supplier");
		String brand = req.getParameter("brand");
		String cutoff = req.getParameter("cutoff");
		String costPrice = req.getParameter("costPrice");
		RevanProduct product = new RevanProduct();
		product.setProductName(productName);
		product.setDir_id(Long.valueOf(dir_id));
		product.setSalePrice(new BigDecimal(salePrice));
		product.setSupplier(supplier);
		product.setBrand(brand);
		product.setCutoff(new BigDecimal(cutoff));
		product.setCostPrice(new BigDecimal(costPrice));

		//2、处理业务逻辑
		if (hasLength(id)) {
			//编辑
			product.setId(Long.valueOf(id));
			productDAO.update(product);
		}
		else {
			//新增
			productDAO.save(product);
		}
		//3、跳转界面
		resp.sendRedirect("/product");
	}

	protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1、获取请求参数
		String id = req.getParameter("id");
		//2、处理业务请求
		productDAO.delete(Long.valueOf(id));;
		//3、跳转页面
		resp.sendRedirect("/product");
	}
	
	protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1、获取请求参数
		String idString = req.getParameter("id");
		//2、处理业务逻辑
		RevanProduct product = null;
		if (hasLength(idString)) {
			//编辑
			product = productDAO.getProduct(Long.valueOf(idString));
		}
		else {
			//新增
		}
		req.setAttribute("product", product);
		//3、跳转界面
		req.getRequestDispatcher("/WEB-INF/JSP/productEdit.jsp").forward(req, resp);
	}
	
	protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1、获取请求参数
		//2、处理业务请求
		List<RevanProduct> list = productDAO.getList();
		req.setAttribute("list", list);
		//3、跳转界面
		req.getRequestDispatcher("/WEB-INF/JSP/productList.jsp").forward(req, resp);
	}
	
	boolean hasLength(String string) {
		return string != null && string.length() > 0;
	}
	
}
