package com.javatechie.redis.controller;

import com.javatechie.redis.entity.LoginEntity;
import com.javatechie.redis.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/auth/login")
    public String generateToken(@RequestBody LoginEntity loginEntity) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginEntity.getUsername(), loginEntity.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("invalid Username / Password!!");
        }
        return jwtUtil.generateToken(loginEntity.getUsername());
    }

}
