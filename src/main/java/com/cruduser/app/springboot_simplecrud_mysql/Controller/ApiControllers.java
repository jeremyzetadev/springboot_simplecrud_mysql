package com.cruduser.app.springboot_simplecrud_mysql.Controller;

import com.cruduser.app.springboot_simplecrud_mysql.Models.User;
import com.cruduser.app.springboot_simplecrud_mysql.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiControllers {

    private final UserService userService;

    @Autowired
    public ApiControllers(final UserService userService){
        this.userService = userService;
    }

    @GetMapping("/")
    public String getPage(){
        return "Welcome";
    }

    @GetMapping(value="/users")
    public List<User> getUsers(){
        return userService.findAll();
    }

    @PostMapping(value="/save")
    public String saveUser(@RequestBody User user){
        userService.save(user);
        return "Saved...";
    }

    @PutMapping(value="/update/{id}")
    public String updateUser(@PathVariable long id, @RequestBody User user){
        User updatedUser = userService.findById(id);
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setOccupation(user.getOccupation());
        updatedUser.setAge(user.getAge());
        userService.save(updatedUser);
        return "Updated... user with id: " + id;
    }

    @DeleteMapping(value="/delete/{id}")
    public String deleteUser(@PathVariable long id){
        User deleteUser = userService.findById(id);
        userService.delete(deleteUser);
        return "Deleted user with id: " + id;
    }

    // [for returning a response as json see actuator]
    // https://spring.io/guides/gs/actuator-service

    // [getting data from form submission]
    // ※FRONTEND※
    // <form action="/posting" method="post" id="form">
    //   <input type ="text" name="someName"/>
    //   <button type="submit" id="button2" >Submit2</button>
    // </form>
    // ※BACKEND※
    // @PostMapping("/posting")
    // public String po(@RequestParam("someName") String someName) {
    //    return "hello" + someName;
    // }

}
