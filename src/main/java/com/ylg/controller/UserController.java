package com.ylg.controller;

import com.ylg.common.Result;
import com.ylg.common.ResultGenerator;
import com.ylg.pojo.User;
import com.ylg.service.UserService;
import com.ylg.utils.MD5Utils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public Result createUser(@RequestBody User user) throws Exception {
        String MD5pwd = MD5Utils.MD5Encode(user.getPassword(), "UTF-8");
        user.setPassword(MD5pwd);
        int resultCount = userService.createUser(user);
        if(resultCount > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("FAIL");
        }
    }

    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    public Result updateUser(@RequestBody User user) throws Exception {

        if (user.getPassword() != null) {
            String MD5pwd = MD5Utils.MD5Encode(user.getPassword(), "UTF-8");
            user.setPassword(MD5pwd);
        }
        int resultCount = userService.updateUser(user);
        if(resultCount > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("FAIL");
        }
    }

    @RequestMapping(value = "/user/{deleteId}", method = RequestMethod.DELETE)
    public Result deleteUser(@PathVariable("deleteId") String deleteId) throws Exception {
        int resultCount = userService.deleteUser(Integer.valueOf(deleteId));
        if(resultCount > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("FAIL");
        }
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public Result getUserById(@RequestParam("id") Integer id) throws Exception {
        User user = userService.getUserById(id);
        if(user != null) {
            return ResultGenerator.genSuccessResult(user);
        } else {
            return ResultGenerator.genFailResult("FAIL");
        }
    }

    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    public Result getAllUser() throws Exception {
        List<User> users = userService.getAllUser();
        if(users != null) {
            return ResultGenerator.genSuccessResult(users);
        } else {
            return ResultGenerator.genFailResult("FAIL");
        }
    }
}
