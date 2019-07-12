/**
 * 
 */
package com.revanwang.product.query;

import java.math.BigDecimal;

import lombok.Data;

/**
 * @Desc 	
 * @author Revan Wang
 *
 * @Date Jul 12, 201911:59:00 AM
 */
@Data
public class RevanProductQueryObject {
	private String productName;
	private BigDecimal minPrice;
	private BigDecimal maxPrice;
}
