package com.dung2_backend.controller;

import com.dung2_backend.DTO.UserDTO;
import com.dung2_backend.Utils.Utils;
import com.dung2_backend.entity.User;
import com.dung2_backend.secure.CustomUserDetails;
import com.dung2_backend.secure.JWTTokenProvider;
import com.dung2_backend.servive.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(path="/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JWTTokenProvider tokenProvider;

    @PostMapping(path="/create")
    public ResponseEntity create (@RequestBody User user) {
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            UserDTO userDTO = new UserDTO(userService.create(user));
            return ResponseEntity.ok(userDTO);
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(Utils.responseError(e));
        }
    }

    @GetMapping()
    public ResponseEntity get (@RequestParam Integer id) {
        try {
            UserDTO userDTO = new UserDTO(userService.get(id));
            return ResponseEntity.ok(userDTO);
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(Utils.responseError(e));
        }
    }

    @PostMapping(path="/delete")
    public ResponseEntity delete (@RequestParam Integer id) {
        try {
            userService.delete(id);
            return ResponseEntity.ok("Delete Success");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(Utils.responseError(e));
        }
    }

    @PostMapping(path="/login")
    public ResponseEntity login (@RequestParam String account, @RequestParam String password){
        try{
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(account, password)
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);

            String jwt = tokenProvider.generateToken((UserDetails) authentication.getPrincipal());

            return ResponseEntity.ok(jwt);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Utils.responseError(e));
        }
    }


}
