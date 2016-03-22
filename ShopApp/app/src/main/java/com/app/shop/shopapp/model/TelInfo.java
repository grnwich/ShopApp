package com.app.shop.shopapp.model;

import com.google.gson.Gson;

import java.util.List;

/**
 * <请描述这个类是干什么的>
 *
 * @author lwli
 * @data: 2016/3/17 10:51
 * @version: V1.0
 */
public class TelInfo {

    /**
     * data : [{"id":"1","phone":"110","title":"火警"}]
     * msg : 成功
     * code : 200
     */

    private String msg;
    private String code;
    /**
     * id : 1
     * phone : 110
     * title : 火警
     */
    public static TelInfo parse(String obj){
        TelInfo telInfo =new Gson().fromJson(obj,TelInfo.class);
        return telInfo;
    }

    private List<DataEntity> data;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public String getCode() {
        return code;
    }

    public List<DataEntity> getData() {
        return data;
    }

    public static class DataEntity {
        private String id;
        private String phone;
        private String title;

        public void setId(String id) {
            this.id = id;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getId() {
            return id;
        }

        public String getPhone() {
            return phone;
        }

        public String getTitle() {
            return title;
        }
    }
}
