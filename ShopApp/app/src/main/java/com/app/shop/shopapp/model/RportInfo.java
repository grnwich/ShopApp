package com.app.shop.shopapp.model;

import com.google.gson.Gson;

import java.util.List;

/**
 * <请描述这个类是干什么的>
 *
 * @author lwli
 * @data: 2016/3/17 10:00
 * @version: V1.0
 */
public class RportInfo {
    List<ReportItem>data;
    public static RportInfo parse(String obj){
        RportInfo rportInfo=null;
        rportInfo =new Gson().fromJson(obj,RportInfo.class);
        return rportInfo;
    }

    public void setData(List<ReportItem> data) {
        this.data = data;
    }

    public List<ReportItem> getData() {
        return data;
    }
}
