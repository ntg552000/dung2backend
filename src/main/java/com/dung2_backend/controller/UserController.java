package com.dung2_backend.controller;

import com.dung2_backend.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping(path="/create")
    public ResponseEntity createUser (@RequestBody User user) {
        userRepository.save(user);
        return ResponseEntity.ok("created");
    }

}
