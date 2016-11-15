package com.lh.fastjsonlearn;

import com.alibaba.fastjson.JSON;

/**
 * Created by lh on 2016/11/15.
 */
public class App {
    public static void main(String[] args) {
        Group group = new Group();
        group.setId(0L);
        group.setName("admin");

        User guestUser = new User();
        guestUser.setId(2L);
        guestUser.setName("guest");

        User rootUser = new User();
        rootUser.setId(3L);
        rootUser.setName("root");

        group.addUser(guestUser);
        group.addUser(rootUser);

        String jsonString = JSON.toJSONString(group);

        Group g = JSON.parseObject(jsonString,Group.class);

        System.out.println(jsonString);
        System.out.println(g);
    }
}
