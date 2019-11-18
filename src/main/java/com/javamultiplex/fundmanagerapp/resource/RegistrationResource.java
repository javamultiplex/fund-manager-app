package com.javamultiplex.fundmanagerapp.resource;

import com.javamultiplex.fundmanagerapp.entity.User;
import com.javamultiplex.fundmanagerapp.repository.UserRepository;
import com.javamultiplex.fundmanagerapp.service.EncryptionService;
import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/v1")
@Slf4j
@CrossOrigin("*")
public class RegistrationResource {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EncryptionService encryptionService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        String password = encryptionService.encrypt(user.getPassword());
        user.setPassword(password);
        user.setRole("USER");
        user.setRegistrationDate(new Date());
        User savedUser = userRepository.save(user);
        log.info("Saved User : [{}]", savedUser);
        return new ResponseEntity<String>("User Successfully registered with user id : " + savedUser.getId(), HttpStatus.OK);
    }
}
