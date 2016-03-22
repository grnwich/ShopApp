package com.app.shop.shopapp.model;

import java.io.Serializable;

/**
 * <请描述这个类是干什么的>
 *
 * @author lwli
 * @data: 2015/9/12 16:18
 * @version: V1.0
 */
public class FragmentTabItem implements Serializable {
    private int type;
    private String name;
    private int icRes;
    private String info = "";
    private Class clazz;
    private boolean addJourney;
    private String cityName="";


    /**
     * @param type
     * @param name
     * @param icRes
     * @param info
     * @param clazz
     */
    public FragmentTabItem(int type, String name, int icRes, String info,
                           Class clazz) {
        super();
        this.type = type;
        this.name = name;
        this.icRes = icRes;
        this.info = info;
        this.clazz = clazz;
    }

    public FragmentTabItem(int type, String name, int icRes, String info, Class clazz, boolean addJourney, String cityName) {
        this.type = type;
        this.name = name;
        this.icRes = icRes;
        this.info = info;
        this.clazz = clazz;
        this.addJourney = addJourney;
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

    /**
     * @param type
     * @param name
     * @param icRes
     * @param info
     * @param clazz
     */
    public FragmentTabItem(int type, String name, int icRes, String info,
                           Class clazz, boolean temp) {
        super();
        this.type = type;
        this.name = name;
        this.icRes = icRes;
        this.info = info;
        this.clazz = clazz;
        this.addJourney = temp;
    }

    public boolean isAddJourney() {
        return addJourney;
    }

    public void setAddJourney(boolean addJourney) {
        this.addJourney = addJourney;
    }

    public int getType() {
        return type;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIcRes() {
        return icRes;
    }

    public void setIcRes(int icRes) {
        this.icRes = icRes;
    }


}
