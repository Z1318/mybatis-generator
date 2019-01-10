package com.example.demo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "用户对象模型")
public class User {
    @ApiModelProperty(value = "用户id")
    private Integer userId;
    @ApiModelProperty(value = "userName",required = true)
    private String userName;
    @ApiModelProperty(value = "password",required = true)
    private String password;
    @ApiModelProperty(value = "电话号码",required = true,name = "phoneNum")
    private String phone;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }
}