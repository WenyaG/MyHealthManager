package com.littletigerstudio.myhealthmanager.controller;

import com.google.gson.Gson;
import com.littletigerstudio.myhealthmanager.bean.MainMenu;
import com.littletigerstudio.myhealthmanager.dao.MenuDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class MenuController {
    @Autowired
    MenuDao menuDao;

    @RequestMapping("/menus")
    public String getAllMenus() {
        HashMap<String, Object> data = new HashMap<>();
        List<MainMenu> menus = menuDao.getMenus();
        if(menus!=null) {
            data.put("menus", menus);
            data.put("flag", 200);
        } else {
            data.put("flag", 404);
        }
        Gson gson = new Gson();
        return gson.toJson(data);
    }
}
