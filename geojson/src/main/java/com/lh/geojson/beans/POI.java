package com.lh.geojson.beans;

import com.alibaba.fastjson.annotation.JSONField;
import com.vividsolutions.jts.geom.Geometry;

/**
 * Created by lh on 2016/11/17.
 * 返回的数据
 */
public class POI {
    String address;
    String name;
    String tel;
    String GeometryText;

    @JSONField(serialize = false)
    Geometry geometry;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @JSONField(name = "Geometry")
    public String getGeometryText() {
        return this.GeometryText;
    }


    public void setGeometryText(String geometryText) {
        this.GeometryText = geometryText;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
        setGeometryText(geometry.toText());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof POI) {
            POI poi = (POI) obj;
            if (this.name == poi.name && this.address == poi.address && this.tel == poi.tel && this.geometry.equals(poi.geometry)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + this.tel.hashCode() + this.address.hashCode() + this.geometry.hashCode();
    }
}
