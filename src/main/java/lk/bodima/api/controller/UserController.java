package lk.bodima.api.controller;

import lk.bodima.api.controller.request.UserRequest;
import lk.bodima.api.controller.response.UserResponse;
import lk.bodima.api.exception.UserNotFoundException;
import lk.bodima.api.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(value = "users", headers = "X-Api-Version=v1")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {
        return new ResponseEntity<>(userService.createUser(userRequest), HttpStatus.CREATED);
    }

    @GetMapping(value = "/users/{user-id}" , headers = "X-Api-Version=v1")
    public ResponseEntity<UserResponse> getUser(@PathVariable("user-id") Long userId) throws UserNotFoundException {
        return new ResponseEntity<>(userService.getById(userId),HttpStatus.OK);
    }

    @GetMapping(value = "/users", headers = "X-Api-Version=v1")
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }
}
