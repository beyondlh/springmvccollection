package com.lh.ehcache;

/**
 * Created by lh on 2016/12/26.
 */

import java.io.Serializable;
import java.util.HashMap;
/**
 * @author lh
 */
public class Car implements Serializable {
    private static final long serialVersionUID = -1446811249149497780L;
    private String make;
    private String model;
    private String vin;

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }
}
