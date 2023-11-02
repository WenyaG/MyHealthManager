package com.littletigerstudio.myhealthmanager.controller;

import com.google.gson.Gson;
import com.littletigerstudio.myhealthmanager.bean.QueryInfo;
import com.littletigerstudio.myhealthmanager.bean.User;
import com.littletigerstudio.myhealthmanager.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserDao udao;

    @RequestMapping("/alluser")
    public String getUserList(QueryInfo queryInfo) {
        //get username and current page
        int numbers = udao.getUserCounts("%"+queryInfo.getQuery()+"%");
        int pageStart = (queryInfo.getPageNum() - 1) * queryInfo.getPageSize();

        List<User> users = udao.getAllUser("%"+queryInfo.getQuery()+"%",
                pageStart, queryInfo.getPageSize());

        HashMap<String, Object> res = new HashMap<>();
        res.put("number", numbers);
        res.put("data", users);
        Gson gson = new Gson();
        return gson.toJson(res);

    }

    @RequestMapping("/userState")
    public String updateUserState(@RequestParam("id")Integer id,
                                  @RequestParam("state")Boolean state){
        int i = udao.updateState(id, state);
        return i > 0 ? "success" : "error";
    }

    @RequestMapping("/addUser")
    public String addUser(@RequestBody User user){
        user.setRole("general user");
        user.setState(false);
        int i = udao.addUser(user);
        return i > 0 ? "success":"error";
    }
}
