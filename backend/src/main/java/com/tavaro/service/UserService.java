package com.tavaro.service;

import com.tavaro.dto.UserDTO;
import com.tavaro.exception.JobPortalException;

public interface UserService {
    public UserDTO registerUser(UserDTO userDTO) throws JobPortalException;
}
