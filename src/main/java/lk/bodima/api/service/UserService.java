package lk.bodima.api.service;

import lk.bodima.api.controller.request.UserRequest;
import lk.bodima.api.controller.response.UserResponse;
import lk.bodima.api.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    UserResponse createUser(UserRequest userRequest);

    UserResponse getById(Long userId) throws UserNotFoundException;

    List<UserResponse> getAll();

    UserResponse updateById(Long userId, UserRequest userRequest) throws UserNotFoundException;
}
