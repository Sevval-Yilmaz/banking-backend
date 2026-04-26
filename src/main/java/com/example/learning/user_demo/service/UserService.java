package com.example.learning.user_demo.service;

import com.example.learning.user_demo.dto.UserRequestDto;
import com.example.learning.user_demo.dto.UserResponseDto;
import com.example.learning.user_demo.entity.User;
import com.example.learning.user_demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) { // Construtor Injection? Wieso braucht man das?
        this.userRepository = userRepository;
    }

    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> {
                    UserResponseDto dto = new UserResponseDto();
                    dto.setId(user.getId());
                    dto.setName(user.getName());
                    dto.setEmail(user.getEmail());
                    dto.setBalance(user.getBalance());
                    return dto;
                })
                .toList();
    }

    public UserResponseDto getUserById(Long id) {

        // findet id in der DB oder nicht
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        // user infos werden für den controller ready gemacht, damit das im FE landet
        UserResponseDto dto = new UserResponseDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setBalance(user.getBalance());
        return dto;
    }

    public UserResponseDto createUser(UserRequestDto requestDto) {

        User user = new User();
        user.setName(requestDto.getName());
        user.setEmail(requestDto.getEmail());
        user.setBalance(requestDto.getBalance());

        User saveUser = userRepository.save(user);

        UserResponseDto responseDto = new UserResponseDto();
        responseDto.setId(saveUser.getId());
        responseDto.setName(saveUser.getName());
        responseDto.setEmail(saveUser.getEmail());
        responseDto.setBalance(saveUser.getBalance());

        return responseDto;
    }

    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        userRepository.delete(user);
    }
}
