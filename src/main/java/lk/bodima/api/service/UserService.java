package lk.bodima.api.service;

import lk.bodima.api.controller.request.UserRequest;
import lk.bodima.api.controller.response.UserResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    UserResponse createUser(UserRequest userRequest);
}
