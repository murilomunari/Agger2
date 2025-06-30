package com.agger.Controller;

import com.agger.DTO.UserDTO;
import com.agger.Model.User;
import com.agger.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {

    public final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> create(@Valid @RequestBody UserDTO data) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(data));
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}
