package com.example.demo.service;

import com.example.demo.model.User;
import java.util.List;

/**
 * @ Author     ：ZYP
 * @ Date       ：Created in 17:05 2019/1/5
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
public interface UserService {
    int addUser(User user);
    List<User> findAllUser(int pageNum,int pageSize);
}
