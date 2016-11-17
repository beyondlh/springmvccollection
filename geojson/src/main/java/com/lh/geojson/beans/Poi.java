package com.lh.geojson.beans;

import com.vividsolutions.jts.geom.Geometry;

/**
 * Created by lh on 2016/11/17.
 * 返回的数据
 */
public class Poi {
    String address;
    String name;
    String tel;

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

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Poi) {
            Poi poi = (Poi) obj;
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
