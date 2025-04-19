package com.cruduser.app.springboot_simplecrud_mysql.Service;

import com.cruduser.app.springboot_simplecrud_mysql.Models.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    void save(User user);

    User findById(long id);

    void delete(User user);
}
