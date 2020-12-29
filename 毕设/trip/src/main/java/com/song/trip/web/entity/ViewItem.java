package com.song.trip.web.entity;

import com.song.trip.web.domain.ViewPoint;

import java.io.Serializable;

public class ViewItem implements Serializable {
    /**
     * 商品
     * **/
    private ViewPoint viewPoint;
    /**
     * 商品数量
     * **/
    private Integer viewCount;
    public ViewItem(){}

    public ViewItem(ViewPoint viewPoint, Integer viewCount) {
        this.viewPoint = viewPoint;
        this.viewCount = viewCount;
    }

    public ViewPoint getViewPoint() {
        return viewPoint;
    }

    public void setViewPoint(ViewPoint viewPoint) {
        this.viewPoint = viewPoint;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    /**
     * 获得当前项的总价
     * **/
    public Double getSumPrice(){
        double sum=viewCount*viewPoint.getTpPrice();
        return sum;
    }
    @Override
    public String toString() {
        return "ViewItem{" +
                "viewPoint=" + viewPoint +
                ", viewCount=" + viewCount +
                '}';
    }
}
