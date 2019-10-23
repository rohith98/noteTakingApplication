package com.app.note.controller;

import com.app.note.entity.User;
import com.app.note.request.UserRequest;
import com.app.note.response.UserResponse;
import com.app.note.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping({"/user"})
public class UserController {
    @Autowired
    private UserService userService;

//    @PostMapping("/find")
//    public UserResponse fetchUser(@RequestBody UserRequest userRequest){
//        return userService.fetchUser(userRequest.getUserId());
//    }

    @PostMapping("/login")
    public UserResponse loginUser(@RequestBody UserRequest userRequest, HttpServletResponse response){
        return userService.loginUser(userRequest, response);
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody UserRequest userRequest, HttpServletResponse response){
        userService.registerUser(userRequest, response);
        if(response.getStatus()==HttpServletResponse.SC_CREATED){
            return "User Created Successfully";
        }
        else{
            return "User Already Exist";
        }
    }
}
