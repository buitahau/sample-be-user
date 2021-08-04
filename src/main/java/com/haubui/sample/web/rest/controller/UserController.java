package com.haubui.sample.web.rest.controller;

import com.haubui.sample.common.exception.GeneralException;
import com.haubui.sample.service.UserService;
import com.haubui.sample.util.mapper.UserMapperUtil;
import com.haubui.sample.web.rest.dto.UserDto;
import com.haubui.sample.web.rest.response.UserResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @PostMapping("/add")
    public ResponseEntity<UserResponse> add(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(UserMapperUtil.parseToResponse(_userService.add(userDto)));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getByUserId(@PathVariable("userId") String userId) {
        return ResponseEntity.ok(UserMapperUtil.parseToResponse(_userService.getById(userId)));
    }

    @GetMapping("/find-all")
    public ResponseEntity<List<UserResponse>> findAll() {
        return ResponseEntity.ok(
            _userService.findAll()
                .stream()
                .map(userDto -> UserMapperUtil.parseToResponse(userDto))
                .collect(Collectors.toList())
        );
    }

    @PostMapping("/verify-account")
    public ResponseEntity<UserResponse> verifyAccount(@RequestBody UserDto userDto) throws GeneralException {
        return ResponseEntity.ok(UserMapperUtil.parseToResponse(_userService.verifyAccount(userDto)));
    }

    @Autowired
    private UserService _userService;

    private final Logger _log = LoggerFactory.getLogger(UserController.class);
}
