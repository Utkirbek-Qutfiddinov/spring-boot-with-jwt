package uz.utkirbek.springbootwithjwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.utkirbek.springbootwithjwt.payload.LoginDto;
import uz.utkirbek.springbootwithjwt.security.JwtProvider;
import uz.utkirbek.springbootwithjwt.service.AuthService;

/**
 * Author: utkirbek.
 * Time: 21:41:40
 * Date: July 14, 2023, Friday
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    JwtProvider jwtProvider;
    @Autowired
    AuthService authService;

    @PostMapping("/login")
    public HttpEntity<?> login(@RequestBody LoginDto loginDto){
        UserDetails userDetails=authService.loadUserByUsername(loginDto.getUsername());
        if(userDetails.getPassword().equals(loginDto.getPassword())){
            return ResponseEntity.ok(jwtProvider.generateToken(loginDto.getUsername()));
        }
        return ResponseEntity.status(401).body("Login or password is incorrect!");
    }
}
