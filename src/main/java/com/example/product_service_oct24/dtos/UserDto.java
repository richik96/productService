package com.example.product_service_oct24.dtos;

import java.util.List;

// import com.scaler.user_service_oct24.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private String email;
    private String password;
    private String username;
    private List<Role> roles;
   // private NameDto name;

}
