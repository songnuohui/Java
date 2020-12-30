package com.zt.util;
public class PageUtil {
    private int currPage;    //当前页
    private int pageSize;   //每页大小
    private int totalSize;  //总记录数
    private int totalPage;  //总页数
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}
	public int getTotalPage() {
		return totalPage;
	}
	// 计算总页数的方法    10  4条   
	public void setTotalPage(int totalSize) {
		if(totalSize%this.pageSize==0){
			this.totalPage = totalSize/this.pageSize;
		}else{
			this.totalPage = totalSize/this.pageSize+1;
		}	
	}
    
    
    
}
