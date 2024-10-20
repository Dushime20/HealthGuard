package com.codewithdush.HealthGuard.controller;


import com.codewithdush.HealthGuard.Dto.LoginRequest;
import com.codewithdush.HealthGuard.Dto.ResetPassword;
import com.codewithdush.HealthGuard.Dto.Response;
import com.codewithdush.HealthGuard.entity.User;
import com.codewithdush.HealthGuard.service.Intrefac.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private IUserService userService;

    @PostMapping("/register")
    public ResponseEntity<Response> register(@RequestBody User user) {
        Response response = userService.register(user);
        return ResponseEntity.status(response.getStatusCode()).body(response);

    }

    @PostMapping("/login")
    public ResponseEntity<Response> register(@RequestBody LoginRequest loginRequest) {
        Response response = userService.login(loginRequest);
        return ResponseEntity.status(response.getStatusCode()).body(response);

    }


    @PutMapping("/reset-password/{userId}")
    public ResponseEntity<Response> resetPassword(@PathVariable("userId") Long userId,
                                                  @RequestBody ResetPassword resetPassword

                                                  ){


        Response response = userService.resetPassword(userId, resetPassword.getEmail(),
                resetPassword.getPassword());
        return ResponseEntity.status(response.getStatusCode()).body(response);

    }
}