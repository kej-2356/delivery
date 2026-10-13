package com.example.delivery.user.service;

import com.example.delivery.global.exception.CustomException;
import com.example.delivery.global.exception.ErrorCode;
import com.example.delivery.user.dto.request.SignupRequest;
import com.example.delivery.user.entity.User;
import com.example.delivery.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void signup(SignupRequest request) {
        if (userRepository.existsByName(request.getName())) {
            throw new CustomException(ErrorCode.DUPLICATE_NAME);
        }

        String password = passwordEncoder.encode(request.getPassword());
        User user = new User(request.getName(), password, request.getRole());

        userRepository.save(user);
    }
}
