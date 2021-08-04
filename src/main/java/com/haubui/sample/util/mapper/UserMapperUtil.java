package com.haubui.sample.util.mapper;

import com.haubui.sample.domain.User;
import com.haubui.sample.web.rest.dto.UserDto;
import com.haubui.sample.web.rest.response.UserResponse;
import org.modelmapper.ModelMapper;

public class UserMapperUtil {

    public static UserDto parseToDto(User user) {
        return _modelMapper.map(user, UserDto.class);
    }

    public static UserResponse parseToResponse(UserDto userDto) {
        return _modelMapper.map(userDto, UserResponse.class);
    }

    private static final ModelMapper _modelMapper = new ModelMapper();
}
