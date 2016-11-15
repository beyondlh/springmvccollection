package com.lh.fastjsonlearn;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by lh on 2016/11/15.
 */
public class User {

    @JSONField(serialize = false)
    private Long id;

    @JSONField(name="CustomName",serializeUsing = GeometrySerizalier.class)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}