package com.tavaro.service;

import com.tavaro.dto.UserDTO;
import com.tavaro.entity.User;
import com.tavaro.exception.JobPortalException;
import com.tavaro.repository.UserRepository;
import com.tavaro.utility.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class userServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDTO registerUser(@org.jetbrains.annotations.NotNull UserDTO userDTO) throws JobPortalException {
        userDTO.setId(Utilities.getNextSequence("users"));
        User user = userDTO.toEntity();
        user = userRepository.save(user);
        return user.toDTO();
    }
}
