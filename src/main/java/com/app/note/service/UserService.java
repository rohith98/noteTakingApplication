package com.app.note.service;

import com.app.note.entity.User;
import com.app.note.repository.UserRepository;
import com.app.note.request.UserRequest;
import com.app.note.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

//    public UserResponse fetchUser(Integer userId) {
//        UserResponse userResponse = new UserResponse();
//
//        Optional<User> user=userRepository.findById(userId);
//
//        if(user.isPresent()) {
//            userResponse.setUserName(user.get().getUserName());
//            userResponse.setPassword(user.get().getPassword());
//            userResponse.setGroups(user.get().getGroups());
//        }
//
//        return userResponse;
//    }

    public String registerUser(UserRequest userRequest){
        User user = new User();

        user.setUserName(userRequest.getUserName());
        user.setPassword(userRequest.getPassword());

        if(userRepository.findByUserName(user.getUserName())==null){
            userRepository.save(user);
            return "Registered Successfully";
        }

        return "User already exist";
    }

    public String loginUser(UserRequest userRequest){
        Optional<User> user;

        user = userRepository.findByUserNameAndPassword(userRequest.getUserName(),userRequest.getPassword());

        if(user.isPresent()){
            return "login Successful";
        }

        return "Invalid Credentials";
    }
}
