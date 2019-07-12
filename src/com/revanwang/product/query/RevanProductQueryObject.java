/**
 * 
 */
package com.revanwang.product.query;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.revanwang.product.query.impl.RevanQueryObject;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @Desc 	
 * @author Revan Wang
 *
 * @Date Jul 12, 201911:59:00 AM
 */
@Getter
@Setter
public class RevanProductQueryObject extends RevanQueryObject {
	private String productName;
	private BigDecimal minPrice;
	private BigDecimal maxPrice;

	@Override
	public void customQuery() {
		//如果商品名称存在
		if (super.hasLength(productName)) {
			super.addQuery("productName Like ?", "%" + productName + "%");
		}

		if (minPrice != null) {
			super.addQuery("salePrice >= ?", minPrice);
		}

		if (maxPrice != null) {
			super.addQuery("salePrice <= ?", maxPrice);
		}
	}
}
