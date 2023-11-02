package com.littletigerstudio.myhealthmanager.dao;

import com.littletigerstudio.myhealthmanager.bean.MainMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuDao {
    public List<MainMenu> getMenus();

}
