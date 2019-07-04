/**
 * 
 */
package com.revanwang.product.domain;

import java.math.BigDecimal;

import lombok.Data;

/**
 * @Desc 	
 * @author Revan Wang
 *
 * @Date Jul 4, 20194:00:17 PM
 */
@Data
public class RevanProduct {
	private Long id;
	private String productName;
	private Long dir_id;
	private BigDecimal salePrice;
	private String supplier;
	private String brand;
	private BigDecimal cutoff;
	private BigDecimal costPrice;
}
