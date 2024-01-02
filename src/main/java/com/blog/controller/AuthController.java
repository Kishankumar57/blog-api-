package com.blog.controller;


import com.blog.Security.JwtTokenProvider;
import com.blog.entity.Role;
import com.blog.entity.User;
import com.blog.payload.JWTAuthResponse;
import com.blog.payload.LoginDto;
import com.blog.payload.SignUpDto;
import com.blog.repository.RoleRepository;
import com.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")

public class AuthController {

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    private AuthenticationManager authenticationManager;  // gives  loginDto  to loadUserByUsername method of

    @Autowired
    private RoleRepository roleRepository;
    // functional interface UserDetailsService

    @PostMapping("/signin")
    public ResponseEntity<JWTAuthResponse> authenticateUser( @RequestBody LoginDto loginDto){

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =

                new UsernamePasswordAuthenticationToken(loginDto.getUsernameOrEmail(), loginDto.getPassword());

        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        // comparison with user email and password is done here  like an if condition
        // comparison of loginDto data  with user data  present in db with
        //authenticate method automatically calls loadUserByUsername

        SecurityContextHolder.getContext().setAuthentication(authentication);   // just like a session  creation  in jsp servlet session.setAttribute

        // get token form tokenProvider
        String token = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JWTAuthResponse(token));


    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUpDto signUpDto ) {

    if(userRepository.existsByEmail(signUpDto.getEmail())){

    return new ResponseEntity<>("EmailId  already exists:"+signUpDto.getEmail(),HttpStatus.INTERNAL_SERVER_ERROR);
}

        if(userRepository.existsByUsername(signUpDto.getUsername())){

            return new ResponseEntity<>("Username  already exists :"+signUpDto.getUsername(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

       User user  = new User();
       user.setName(signUpDto.getName());
       user.setEmail(signUpDto.getEmail());
       user.setUsername(signUpDto.getUsername());
       user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));


        Optional<Role> roleAdmin = roleRepository.findByName("ROLE_ADMIN"); //mapping od role id to the user
        Role roles = roleAdmin.get();

        user.setRoles(Collections.singleton(roles));

        userRepository.save(user);

        return  new ResponseEntity<>("user registered successfully", HttpStatus.OK);

    }

    }
