package com.example.meetuteam2.controllers;

import com.example.meetuteam2.DTO.UserDTO;
import com.example.meetuteam2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/createuser")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok().body(userService.createUser(userDTO));
    }

    @GetMapping("/allusers")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok().body(userService.getAllActiveUsers());
    }

    @GetMapping("/finduser/{id}")
    public ResponseEntity<Optional<UserDTO>> getUserById(@RequestParam Long id) {
        Optional<UserDTO> userOptional = userService.getUserById(id);
        if(userOptional.isPresent()) {
            return ResponseEntity.ok(userOptional);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/updateuserbyid/{id}")
    public ResponseEntity<UserDTO> updateUserById(@PathVariable Long id,
                                               @RequestBody UserDTO userDTO) {
        Optional<UserDTO> userOptional = userService.updateUserById(id, userDTO);
        if(userOptional.isPresent()) {
            return ResponseEntity.ok().body(userOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/deleteuser")
    public ResponseEntity<UserDTO> deleteUser(@PathVariable Long id) {
        Optional<UserDTO> userOptional = userService.updateUserRecordStatus(id);
        if (userOptional.isPresent()) {
            return ResponseEntity.ok(userOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
