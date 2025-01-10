package lk.bodima.api.service.impl;

import lk.bodima.api.controller.request.UserRequest;
import lk.bodima.api.controller.response.UserResponse;
import lk.bodima.api.exception.UserNotFoundException;
import lk.bodima.api.model.User;
import lk.bodima.api.repository.UserRepository;
import lk.bodima.api.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        User user = modelMapper.map(userRequest, User.class);
        UserResponse userResponse = modelMapper.map(userRepository.save(user), UserResponse.class);
        return userResponse;
    }

    @Override
    public UserResponse getById(Long userId) throws UserNotFoundException {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new UserNotFoundException (" User not found in id" + userId));

        return modelMapper.map(user,UserResponse.class);
    }
}

