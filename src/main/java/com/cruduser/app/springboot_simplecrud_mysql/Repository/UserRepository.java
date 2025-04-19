package com.cruduser.app.springboot_simplecrud_mysql.Repository;

import com.cruduser.app.springboot_simplecrud_mysql.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
