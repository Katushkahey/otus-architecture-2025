package com.otus.homework.service;

import com.otus.homework.dto.UserDto;
import com.otus.homework.mappper.UserMapper;
import com.otus.homework.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserService {

    private static final String USER_WITH_ID_S_NOT_FOUND = "User with id: %s not found";
    private final UserMapper mapper;
    private final UserRepository userRepository;

    @Transactional
    public UserDto createUser(UserDto dto) {
        var user = mapper.toEntity(dto);
        var savedUser = userRepository.save(user);
        return mapper.toDto(savedUser);
    }

    public UserDto getById(Long userId) {
        var user = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException(USER_WITH_ID_S_NOT_FOUND.formatted(userId)));
        return mapper.toDto(user);
    }

    @Transactional
    public UserDto updateUser(Long userId, UserDto dto) {
        var user = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException(USER_WITH_ID_S_NOT_FOUND.formatted(userId)));

        mapper.updateEntityFromDto(dto, user);

        var updatedUser = userRepository.save(user);
        return mapper.toDto(updatedUser);
    }

    @Transactional
    public void deleteUser(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new NoSuchElementException(USER_WITH_ID_S_NOT_FOUND.formatted(userId));
        }
        userRepository.deleteById(userId);
    }
}
