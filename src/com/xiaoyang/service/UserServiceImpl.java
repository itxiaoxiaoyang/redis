package com.xiaoyang.service;

import com.xiaoyang.bean.Student;
import com.xiaoyang.dao.UserDao;

import java.util.List;

/**
 * @author 小帅杨
 * @version v1.0
 * @date 2019/3/15/0015 23:39
 * @description TODO
 **/
public class UserServiceImpl {
    private UserDao userDao = new UserDao();
    public String queryAll() {
        String s = userDao.queryAll();
        return s;
    }
}
