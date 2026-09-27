package com.adaptive.backend.controller;

/**
 * @author ivek5
 **/


import com.adaptive.backend.dto.RegisterRequest;
import com.adaptive.backend.dto.UserResponse;
import com.adaptive.backend.entity.User;
import com.adaptive.backend.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public UserResponse registerUser(
            @Valid @RequestBody RegisterRequest request
    ) {

        User user = userService.registerUser(request);

        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole(),
                user.getActive(),
                user.getCreatedAt()
        );
    }
}