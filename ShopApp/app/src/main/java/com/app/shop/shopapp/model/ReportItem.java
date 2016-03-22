package com.app.shop.shopapp.model;

/**
 * <请描述这个类是干什么的>
 *
 * @author lwli
 * @data: 2016/3/17 10:01
 * @version: V1.0
 */
public class ReportItem {
    private int community_id;
    private int type;
    private String title="";
    private String content="";
    private String community_name="";
    private long dateline;

    public String getCommunity_name() {
        return community_name;
    }

    public void setCommunity_name(String community_name) {
        this.community_name = community_name;
    }

    public long getDateline() {
        return dateline;
    }

    public void setDateline(long dateline) {
        this.dateline = dateline;
    }

    public int getCommunity_id() {
        return community_id;
    }

    public void setCommunity_id(int community_id) {
        this.community_id = community_id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
