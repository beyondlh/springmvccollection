package com.hdsx.lh;

import java.io.Serializable;

/**
 * Created by lh on 2016/3/31.
 */
public class User implements Serializable{

    private static final long serialVersionUID = 2690992528875523345L;
    //    private static final long serialVersionUID = -929994095467892899L;
    String name;
    //    性别
    String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
