package com.example.product_service_oct24.commons;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.product_service_oct24.dtos.UserDto;

@Service
public class AuthenticationCommons {

    private RestTemplate restTemplate;

    private AuthenticationCommons(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public boolean validateToken(String token) {

        ResponseEntity<UserDto> userDtoResponse = restTemplate.postForEntity(
                            "https://localhost:8181/user/validate/"+token, 
                            null,
                            UserDto.class
                            );

        if(userDtoResponse.getBody() == null) {
            return false;
        }
        return true;
    }
}
