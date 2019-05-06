package com.xiaoyang.dao;

import com.alibaba.fastjson.JSON;
import com.xiaoyang.bean.Student;
import com.xiaoyang.utils.JdbcTemplateUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author 小帅杨
 * @version v1.0
 * @date 2019/3/15/0015 23:40
 * @description TODO
 **/
public class UserDao {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcTemplateUtils.getDataSources());

    public String queryAll() {
        String sql = "SELECT * FROM stu_info";
        List<Student> studentList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class));

        String s = JSON.toJSONString(studentList);
        return s;
    }
}
