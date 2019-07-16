/**
 * 
 */
package com.revanwang.product.page;

import java.util.List;

import com.revanwang.product.domain.RevanProductInfo;

import lombok.Getter;

/**
 * @Desc 	
 * @author Revan Wang
 *
 * @Date Jul 15, 20198:19:46 PM
 */
@Getter
public class RevanPageResult {
	private List listData;			//数据列表
	private Integer homePage = 1;	//首页
	private Integer currentPage = 1; //当前页
	private Integer pageSize = 3;	//每页个数
	private Integer previousPage; //上一页
	private Integer nextPage;	//下一页
	private Integer lastPage;	//最后一页
	private Integer totalCount;		//总个数
	
	/**
	 * 
	 */
	public RevanPageResult(Integer currentPage, Integer pageSize, Integer totalSize, List list) {
		this.listData = list;
		this.pageSize = pageSize; 
		this.currentPage = currentPage; 
		
		this.totalCount = totalSize;
		this.lastPage = this.totalCount % this.pageSize == 0 ? this.totalCount / this.pageSize : this.totalCount / this.pageSize + 1;
		this.nextPage = this.currentPage + 1 <= this.lastPage ? this.currentPage + 1 : this.lastPage;
		this.previousPage = this.currentPage - 1 > 0 ? this.currentPage - 1 : 1;
	}
}
