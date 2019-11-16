package com.javamultiplex.fundmanagerapp.resource;

import com.javamultiplex.fundmanagerapp.entity.User;
import com.javamultiplex.fundmanagerapp.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class RegistrationResource {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        user.setRole("USER");
        user.setRegistrationDate(new Date());
        User savedUser = userRepository.save(user);
        log.info("Saved User : [{}]", savedUser);
        return new ResponseEntity<String>("User Successfully registered with user id : " + savedUser.getId(), HttpStatus.OK);
    }
}
