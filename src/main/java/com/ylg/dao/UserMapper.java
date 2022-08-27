package com.ylg.dao;

import com.ylg.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    Integer createUser(User user);

    Integer updateUser(User user);

    Integer deleteUser(@Param("id") Integer id);

    User getUserById(@Param("id") Integer id);

    List<User> getAllUser();
}
