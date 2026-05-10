package com.example.learning.user_demo.service;

import com.example.learning.user_demo.dto.UserRequestDto;
import com.example.learning.user_demo.dto.UserResponseDto;
import com.example.learning.user_demo.entity.User;
import com.example.learning.user_demo.mapper.UserMapper;
import com.example.learning.user_demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(
            UserRepository userRepository,
            UserMapper userMapper
    ) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .toList();
    }

    public UserResponseDto getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        return userMapper.toDto(user);
    }

    public UserResponseDto createUser(UserRequestDto requestDto) {
        User user = new User(
                requestDto.getName(),
                requestDto.getEmail()
        );

        User saveUser = userRepository.save(user);

        return userMapper.toDto(saveUser);
    }

    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        userRepository.delete(user);
    }

    public UserResponseDto updateUser(Long id, UserRequestDto userRequestDto) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found."));

        user.changeName(userRequestDto.getName());
        user.changeEmail(userRequestDto.getEmail());

        User updateUser = userRepository.save(user);

        return userMapper.toDto(updateUser);
    }
}
