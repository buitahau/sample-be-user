package com.haubui.sample.service.impl;

import com.haubui.sample.common.exception.GeneralException;
import com.haubui.sample.domain.User;
import com.haubui.sample.exception.UserException;
import com.haubui.sample.repository.UserRepository;
import com.haubui.sample.service.UserService;
import com.haubui.sample.util.mapper.UserMapperUtil;
import com.haubui.sample.web.rest.dto.UserDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Override
    public UserDto add(UserDto userDto) {
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setUsername(userDto.getUsername());
        user.setPassword(_passwordEncoder.encode(userDto.getPassword()));
        user.setEmail(userDto.getEmail());
        user.setStatus("ACTIVE");
        return UserMapperUtil.parseToDto(_userRepository.save(user));
    }

    @Override
    public UserDto getById(String userId) {
        return UserMapperUtil.parseToDto(_userRepository.findById(userId).get());
    }

    @Override
    public UserDto update(UserDto userDto) {
        return null;
    }

    @Override
    public List<UserDto> findAll() {
        return StreamSupport.stream(_userRepository.findAll().spliterator(), false)
            .map(UserMapperUtil::parseToDto)
            .collect(Collectors.toList());
    }

    @Override
    public UserDto verifyAccount(UserDto userDto) throws UserException {
        validate(userDto);

        Optional<User> optUser = _userRepository.findByUsername(userDto.getUsername());

        if (optUser.isEmpty()) {
            throw new UserException("User not exists.");
        }

        User user = optUser.get();

        if (!_passwordEncoder.matches(userDto.getPassword(), user.getPassword())) {
            throw new UserException("Password is invalid.");
        }
        return UserMapperUtil.parseToDto(user);
    }

    private void validate(UserDto userDto) throws UserException {

        if (userDto == null
            || StringUtils.isBlank(userDto.getUsername())
            || StringUtils.isBlank(userDto.getPassword())) {

            throw new UserException("Missing user information.");
        }
    }

    @Autowired
    private PasswordEncoder _passwordEncoder;

    @Autowired
    private UserRepository _userRepository;
}
