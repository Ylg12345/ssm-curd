package com.ylg.service;

import com.ylg.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;
public interface UserService {

    Integer createUser(User user);

    Integer updateUser(User user);

    Integer deleteUser(@Param("id") int id);

    User getUserById(@Param("id") int id);

    List<User> getAllUser();

}
