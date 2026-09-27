package com.adaptive.backend.dto;

/**
 * @author ivek5
 **/

import com.adaptive.backend.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class UserResponse {

    private Long id;
    private String name;
    private String email;
    private User.Role role;
    private Boolean active;
    private LocalDateTime createdAt;
}
