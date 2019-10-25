package com.app.note.service;

import com.app.note.entity.User;
import com.app.note.repository.UserRepository;
import com.app.note.request.UserRequest;
import com.app.note.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public String registerUser(UserRequest userRequest, HttpServletResponse response){
        if(userRepository.findByUserName(userRequest.getUserName())==null){
            User user = new User();
            user.setUserName(userRequest.getUserName());
            user.setPassword(userRequest.getPassword());
            userRepository.save(user);
            response.setStatus(HttpServletResponse.SC_CREATED);
            return "User Created Successfully";
        }
        else{
            return "User Already Exist";
        }
    }

    public UserResponse loginUser(UserRequest userRequest, HttpServletResponse response){
        Optional<User> user=userRepository.findByUserNameAndPassword(userRequest.getUserName(),
                userRequest.getPassword());
        UserResponse userResponse = new UserResponse();
        if(user.isPresent()){
            userResponse.setUserId(user.get().getUserId());
            userResponse.setUserName(user.get().getUserName());
            userResponse.setStatus("Success");
            response.setStatus(HttpServletResponse.SC_ACCEPTED);
            return userResponse;
        }
        else{
            userResponse.setStatus("Invalid Credentials");
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        return userResponse;
    }
}
