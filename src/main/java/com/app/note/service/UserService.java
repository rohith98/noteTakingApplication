package com.app.note.service;

import com.app.note.entity.User;
import com.app.note.repository.UserRepository;
import com.app.note.request.UserRequest;
import com.app.note.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

//    public UserResponse fetchUser(Integer userId) {
//        UserResponse userResponse = new UserResponse();
//        Optional<User> user=userRepository.findById(userId);
//        if(user.isPresent()) {
//            userResponse.setUserName(user.get().getUserName());
//            userResponse.setPassword(user.get().getPassword());
//            userResponse.setGroups(user.get().getGroups());
//        }
//        return userResponse;
//    }

    public void registerUser(UserRequest userRequest, HttpServletResponse response){
        if(userRepository.findByUserName(userRequest.getUserName())==null){
            User user = new User();
            user.setUserName(userRequest.getUserName());
            user.setPassword(userRequest.getPassword());
            userRepository.save(user);
            response.setStatus(HttpServletResponse.SC_CREATED);
        }
    }

    public UserResponse loginUser(UserRequest userRequest, HttpServletResponse response){
        Optional<User> user=userRepository.findByUserNameAndPassword(userRequest.getUserName(),
                userRequest.getPassword());
        UserResponse userResponse = new UserResponse();
        if(user.isPresent()){
            userResponse.setUserId(user.get().getUserId());
            response.setStatus(HttpServletResponse.SC_ACCEPTED);
            return userResponse;
        }
        return userResponse;
    }
}
