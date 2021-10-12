package com.MBProject.SpringJpa.controller;

import com.MBProject.SpringJpa.dto.OrderRequest;
import com.MBProject.SpringJpa.dto.OrderResponse;
import com.MBProject.SpringJpa.model.User;
import com.MBProject.SpringJpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping()
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public void saveUser(@RequestBody final User user){
        userService.saveUser(user);
    }

    @GetMapping("/getall")
    public List<User> getUserList(){
        return userService.getUserList();
    }

    @DeleteMapping("/delete/{userId}")
    public void deleteUser(@PathVariable final int userId){
        userService.deleteUser(userId);
    }

    //http://localhost:8080/user/put?id=2
    @PutMapping("/put")
    public void updateUser(@RequestParam("id") int id){
        User user1 = userService.getUserById(id);
        user1.setName("abc");
        userService.updateUser(user1);
    }

    @GetMapping("/getId/{userId}")
    public User getUserById(@PathVariable final int userId){
        System.out.println("userId === "+userId);
        return userService.getUserById(userId);
    }

    @GetMapping("/findMultiCondition/{userId}/{name}")
    public List<User> findUserListByMultiConditions(@PathVariable final int userId, @PathVariable final String name){
        return userService.findUserListByMultiConditions(userId, name);
    }

    @GetMapping("/findByIgnoreCase")
    public List<User> findUserListByNameIgnoreCase(@RequestParam("name") String name){
        return userService.findUserListByNameIgnoreCase(name);
    }

    //http://localhost:8080/sortByName/name  or id  or address
    @GetMapping("/sortByName/{name}")
    public List<User> getUserSortByName(@PathVariable final String name){
        return userService.getUserSortByName(name);
    }

    @GetMapping("/getPaginatedUser")
    public Page<User> getPaginatedUser(){
        return userService.getPaginatedUser();
    }

    @GetMapping("/findUserByCustomQuery")
    public List<User> findUserByCustomQuery(){
        return userService.findUserByCustomQuery();
    }

    @GetMapping("/getInfo")
    public List<OrderResponse> getOrderResponses(){
        return userService.getJoinInformation();
    }

    @PostMapping("/placeOrder")
    public void placeOrder(@RequestBody final OrderRequest user){
         userService.saveUser(user.getUser());
    }

}

