package com.cruduser.app.springboot_simplecrud_mysql.Service.impl;

import com.cruduser.app.springboot_simplecrud_mysql.Models.User;
import com.cruduser.app.springboot_simplecrud_mysql.Repository.UserRepository;
import com.cruduser.app.springboot_simplecrud_mysql.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll(){
        return userRepository.findAll();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User findById(long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void delete(User user){
        userRepository.delete(user);
    }
}
