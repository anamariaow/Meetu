package com.example.meetuteam2.controllers;

import com.example.meetuteam2.entities.User;
import com.example.meetuteam2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/adduser")
    public ResponseEntity<User> adduser(@RequestBody User user) {
        userService.createUser(user);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/selectuser")
    public ResponseEntity<List<User>> selectuser() {
        List<User> selectuserlist = userService.userList();
        return ResponseEntity.ok().body(selectuserlist);
    }
}
