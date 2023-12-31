package com.littletigerstudio.myhealthmanager.controller;

import com.google.gson.Gson;
import com.littletigerstudio.myhealthmanager.bean.User;
import com.littletigerstudio.myhealthmanager.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class LoginController {

    @Autowired
    UserDao userDao;

    @RequestMapping ("/login")
    public String login(@RequestBody User user){
        String flag = "error";
        User us= userDao.getUserByMessage(user.getUsername(),
                user.getPassword());
        HashMap<String, Object> res = new HashMap<>();
        if(us != null) {
            flag = "ok";
        }

        res.put("flag", flag);
        res.put("user", user);

        Gson gson = new Gson();
        return gson.toJson(res);
    }

}
