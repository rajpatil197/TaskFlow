package com.taskflow.service;

import com.taskflow.dto.UserCreateRequest;
import com.taskflow.dto.UserResponse;
import com.taskflow.entity.Role;
import com.taskflow.entity.User;
import com.taskflow.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse createUser(UserCreateRequest userRequest) {
        User user = new User();

        user.setName(userRequest.getName());
        user.setPassword(userRequest.getPassword());
        user.setEmail(userRequest.getEmail());
        user.setMobile(userRequest.getMobile());
        user.setRole(Role.EMPLOYEE);
        user.setActive(true);

        User savedUser = userRepository.save(user);

        UserResponse userResponse = new UserResponse();
        userResponse.setUserId(savedUser.getUserId());
        userResponse.setName(savedUser.getName());
        userResponse.setEmail(savedUser.getEmail());
        userResponse.setMobile(savedUser.getMobile());
        userResponse.setRole(savedUser.getRole());
        userResponse.setActive(savedUser.getActive());
        userResponse.setCreatedAt(savedUser.getCreatedAt());

        return userResponse;
    }


}
