package com.xiaoyang.bean;

public class Student {
    private Integer id;
    private String student_name;
    private String student_no;
    private Integer sex;
    private Integer class_id;
    private Integer subject_no;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_no() {
        return student_no;
    }

    public void setStudent_no(String student_no) {
        this.student_no = student_no;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getClass_id() {
        return class_id;
    }

    public void setClass_id(Integer class_id) {
        this.class_id = class_id;
    }

    public Integer getSubject_no() {
        return subject_no;
    }

    public void setSubject_no(Integer subject_no) {
        this.subject_no = subject_no;
    }
}
