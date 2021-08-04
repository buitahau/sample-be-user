package com.haubui.sample.service;

import com.haubui.sample.common.exception.GeneralException;
import com.haubui.sample.web.rest.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto add(UserDto userDto);

    UserDto getById(String userId);

    List<UserDto> findAll();

    UserDto update(UserDto userDto);

    UserDto verifyAccount(UserDto userDto) throws GeneralException;
}
