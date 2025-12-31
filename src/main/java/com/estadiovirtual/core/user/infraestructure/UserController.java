package com.estadiovirtual.core.user.infraestructure;

import com.estadiovirtual.core.user.application.UserService;
import com.estadiovirtual.core.user.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/users")
    public class UserController {
        private UserService userService;
        public UserController(UserService userService){
            this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> CreateUser(@RequestBody User user){
        User createdUser = userService.registerUser(user);
        return ResponseEntity.created(URI.create("/users/" + createdUser.getId())).body(createdUser);
    }
}
