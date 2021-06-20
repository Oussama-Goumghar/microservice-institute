package com.elearning.simplwelearninginstitute.rest;

import com.elearning.simplwelearninginstitute.security.JwtResponse;
import com.elearning.simplwelearninginstitute.security.LoginRequest;
import com.elearning.simplwelearninginstitute.security.jwt.JwtUtils;
import com.elearning.simplwelearninginstitute.security.services.UserDetailsImpl;
import com.elearning.simplwelearninginstitute.service.InstituteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/auth")
public class AuthController {
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);


    // see web security
    // function that returns AuthenticationManager
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    InstituteService instituteService;
    @GetMapping
    public ResponseEntity<?> hello( ) {
        return ResponseEntity.ok("HELLO WORLD");
    }
    @PostMapping
        public ResponseEntity<?> authenticateInstitute( @RequestBody LoginRequest loginRequest) {
        Authentication authentication;
        try{
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getLogin(), loginRequest.getPassword()));
        }
        catch(BadCredentialsException ex){
            return ResponseEntity.badRequest().body("Email Or Password Incorrect");
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        String jwt = jwtUtils.generateJwtToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(jwt,userDetails.getUser().getType(),"Bearer",userDetails.getUser().getId(),
                userDetails.getUsername(),
                userDetails.getUser().getEmail()));
    }
}
