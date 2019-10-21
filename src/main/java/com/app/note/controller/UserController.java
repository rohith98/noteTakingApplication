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
    UserService userService;

//    @PostMapping("/find")
//    public UserResponse fetchUser(@RequestBody UserRequest userRequest){
//        return userService.fetchUser(userRequest.getUserId());
//    }

    @PostMapping("/login")
    public String loginUser(@RequestBody UserRequest userRequest){
        return userService.loginUser(userRequest);
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody UserRequest userRequest, HttpServletResponse response){
        String responseString;

        responseString = userService.registerUser(userRequest);
        if(responseString.equals("Registered Successfully")){
            response.setStatus(201);
        }

        return responseString;
    }
}
