package lyd.learn.springboot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class User {

    private int age;
@JsonIgnore//此处用 过滤密码
    private String pwd;
@JsonProperty("account")
@JsonInclude(JsonInclude.Include.NON_NULL)
    private String phone;
@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",locale = "zh",timezone = "GMT+8")//时间格式化
    private Date creatTime;

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User(int age, String pwd, String phone, Date creatTime) {
        super();
        this.age = age;
        this.pwd = pwd;
        this.phone = phone;
        this.creatTime = creatTime;
    }
}
