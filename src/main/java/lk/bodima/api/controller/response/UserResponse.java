package lk.bodima.api.controller.response;

import lombok.Data;

@Data
public class UserResponse {

    private String firstName;

    private String lastName;

    private String username;

    private String email;

    private String password;

    private String mobileNumber;

    private String imageUrl;
}
