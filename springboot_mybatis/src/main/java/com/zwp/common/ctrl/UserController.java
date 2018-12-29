package com.zwp.common.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zwp.common.entity.User;
import com.zwp.common.mapper.UserMapper;

@RestController
@RequestMapping("/user")
@SuppressWarnings("all")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/")
    public User addUser(User user){
        userMapper.insertByUser(user);
        return user;
    }

    @GetMapping("/list/{phone}")
    public User findUserByPhone(@PathVariable("phone")String phone){
        return userMapper.findUserByPhone(phone);
    }

    @PatchMapping("/")
    public User updateUser(User user){
        userMapper.update(user);
        return userMapper.findUserByPhone(user.getPhone());
    }

    @DeleteMapping("/")
    public int deleteUser(int id){
        userMapper.delete(id);
        return id;
    }

    @GetMapping("/list/all")
    public List<User> findAll(){
        return userMapper.findAll();
    }
}
