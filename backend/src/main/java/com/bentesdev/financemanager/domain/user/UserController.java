package com.bentesdev.financemanager.domain.user;

import com.bentesdev.financemanager.domain.user.dto.CreateUserRequest;
import com.bentesdev.financemanager.domain.user.dto.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(
            @RequestBody CreateUserRequest request
    ){

        User user = userService.registerUser(
                request.getEmail(),
                request.getPassword()
        );

        UserResponse response = new UserResponse(
                user.getId(),
                user.getEmail()
        );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }
}
