package com.zt.util;
public class PageUtil {
    private int currPage;    //��ǰҳ
    private int pageSize;   //ÿҳ��С
    private int totalSize;  //�ܼ�¼��
    private int totalPage;  //��ҳ��
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
	// ������ҳ���ķ���    10  4��   
	public void setTotalPage(int totalSize) {
		if(totalSize%this.pageSize==0){
			this.totalPage = totalSize/this.pageSize;
		}else{
			this.totalPage = totalSize/this.pageSize+1;
		}	
	}
    
    
    
}
