package com.example.meetuteam2.controllers;

import com.example.meetuteam2.DTO.UserRequestDTO;
import com.example.meetuteam2.DTO.UserResponseDTO;
import com.example.meetuteam2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/createuser")
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO userRequestDTO) {
        return ResponseEntity.ok().body(userService.createUser(userRequestDTO));
    }

    @GetMapping("/allusers")
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        return ResponseEntity.ok().body(userService.getAllActiveUsers());
    }

    @GetMapping("/finduser/{id}")
    public ResponseEntity<Optional<UserResponseDTO>> getUserById(@RequestParam Long id) {
        Optional<UserResponseDTO> userOptional = userService.getUserById(id);
        if(userOptional.isPresent()) {
            return ResponseEntity.ok(userOptional);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/updateuserbyid/{id}")
    public ResponseEntity<UserResponseDTO> updateUserById(@PathVariable Long id,
                                                          @RequestBody UserRequestDTO userRequestDTO) {
        Optional<UserResponseDTO> userOptional = userService.updateUserById(id, userRequestDTO);
        if(userOptional.isPresent()) {
            return ResponseEntity.ok().body(userOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/deleteuser/{id}")
    public ResponseEntity<UserResponseDTO> deleteUser(@PathVariable Long id) {
        Optional<UserResponseDTO> userOptional = userService.updateUserRecordStatus(id);
        if (userOptional.isPresent()) {
            return ResponseEntity.ok(userOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/addprofilepicture/{id}")
    public ResponseEntity<String> addProfilePicture(@PathVariable Long id,
                                                    @RequestParam MultipartFile picture) throws IOException {
        Optional<String> userOptional = userService.addProfilePicture(id, picture);
        if(userOptional.isPresent()) {
            return ResponseEntity.ok().body(userOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
