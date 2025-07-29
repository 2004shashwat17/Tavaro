package com.tavaro.service;

import com.tavaro.dto.UserDTO;
import com.tavaro.entity.User;
import com.tavaro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class userServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDTO registerUser(UserDTO userDTO){
        User user = userDTO.toEntity();
        user = userRepository.save(user);
        return user.toDTO();
    }
}
