package com.hdsx.lh;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lh on 2016/4/4.
 */
public class App {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setGender("nan");
            user.setName("lh");
            userList.add(user);
        }
        String jsonString = JSON.toJSONString(userList);
        System.out.println(jsonString);
    }
}