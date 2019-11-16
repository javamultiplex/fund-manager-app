package com.javamultiplex.fundmanagerapp.resource;

import com.javamultiplex.fundmanagerapp.entity.User;
import com.javamultiplex.fundmanagerapp.error.ServiceException;
import com.javamultiplex.fundmanagerapp.model.ErrorResponse;
import com.javamultiplex.fundmanagerapp.model.LoginRequest;
import com.javamultiplex.fundmanagerapp.model.LoginResponse;
import com.javamultiplex.fundmanagerapp.repository.UserRepository;
import com.javamultiplex.fundmanagerapp.service.EncryptionService;
import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sql.rowset.serial.SerialException;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class LoginResource {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EncryptionService encryptionService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        String password = loginRequest.getPassword();
        log.info("password : [{}]",password);
        String email = loginRequest.getEmail();
        log.info("email : [{}]",email);
        User user = userRepository.findByEmail(email);
        if (user == null) {
            String message = "Email is invalid, please try again with valid email id.";
            ErrorResponse errorResponse = ErrorResponse
                    .builder()
                    .userMessage(message)
                    .developerMessage(message)
                    .errorCode(400)
                    .build();
            throw new ServiceException(errorResponse);
        }

        if (!encryptionService.validate(password, user.getPassword())){
            String message = "Password is invalid, please try again with valid password.";
            ErrorResponse errorResponse = ErrorResponse
                    .builder()
                    .userMessage(message)
                    .developerMessage(message)
                    .errorCode(400)
                    .build();
            throw new ServiceException(errorResponse);
        }

        LoginResponse loginResponse = new LoginResponse(user.getName(), user.getId());
        return new ResponseEntity<>(loginResponse, HttpStatus.OK);
    }
}
