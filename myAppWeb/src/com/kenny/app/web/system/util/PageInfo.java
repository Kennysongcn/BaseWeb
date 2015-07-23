package com.kenny.app.web.system.util;

import java.io.Serializable;

/**
 * 分页工具类
 * 创建时需要传入总记录数、当前页数、用户ID
 * @author kennysong
 *
 */
public class PageInfo implements Serializable {

    private static final long serialVersionUID = 587754556498974978L;
    
    //pagesize ，每一页显示多少
    private int showCount = 5;
    //总页数
    private int totalPage;
    //总记录数
    private int totalResult;
    //当前页数
    private int currentPage;
    //查询数据开始
    private int startPage;
    //查询数据结束
    private int endPage;
    @SuppressWarnings("unused")
	private int startPos; // 开始位置，从0开始

	@SuppressWarnings("unused")
	private boolean hasFirst;// 是否有首页

	@SuppressWarnings("unused")
	private boolean hasPre;// 是否有前一页

	@SuppressWarnings("unused")
	private boolean hasNext;// 是否有下一页

	@SuppressWarnings("unused")
	private boolean hasLast;// 是否有最后一页
	
    
    /**

    * 通过构造函数 传入  总记录数  和  当前页
 
    * @param totalCount

    * @param pageNow

    */
  
    public PageInfo(int totalResult, int currentPage) {

    this.totalResult = totalResult;

    this.currentPage = currentPage;
    
	getTotalPage();
	getStartPage();
	getEndPage();
 
    }
    /**
     * 获取总页数，总页数=总记录数/每页显示个数
     * @return 返回总页数
     */
    public int getTotalPage() {
    	totalPage = getTotalResult() / getShowCount();
    	if(totalResult%showCount==0){
    		return totalPage;
    	}else{
    		totalPage =totalPage+1;
    		return	totalPage;
    	}
    }
    
    /**
	 * 获取结束位置
	 * @return 返回查询结束位置
	 */
	public int getEndPage() {
		endPage=currentPage  * showCount;
		return endPage;
	}
	/**
	 * 获取起始位置
	 * @return 返回查询开始位置
	 */
	public int getStartPage() {
		 startPage = getEndPage() - showCount +1;
		return startPage;
	}
	
	/**
	 * 判断是否是第一页
	 * @return true:不是首页   false：是首页
	 */
	public boolean isHasFirst() {
		return (currentPage == 1) ? false : true;
		}
	/**
	 * 是否有上一页
	 * @return 
	 */
	public boolean isHasPre() {
		return  isHasFirst() ? true : false;
	}
	/**
	 * 是否有下一页
	 * @return
	 */
	public boolean isHasNext() {
		return  isHasLast() ? true : false;
	}
	/**
	 * 是否有尾页
	 * @return
	 */
	public boolean isHasLast() {
		return (currentPage == totalPage) ? false : true;
	}


	public int getShowCount() {
		return showCount;
	}

	public void setShowCount(int showCount) {
		this.showCount = showCount;
	}


	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalResult() {
		return totalResult;
	}

	public void setTotalResult(int totalResult) {
		this.totalResult = totalResult;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	/**
	 * 取得选择记录的起始位置
	 * @return
	 */
	public int getStartPos() {
		return (currentPage - 1) * showCount;
	}

	public void setStartPos(int startPos) {
		this.startPos = startPos;
	}


	public void setHasFirst(boolean hasFirst) {
		this.hasFirst = hasFirst;
	}



	public void setHasPre(boolean hasPre) {
		this.hasPre = hasPre;
	}



	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}



	public void setHasLast(boolean hasLast) {
		this.hasLast = hasLast;
	}
}
