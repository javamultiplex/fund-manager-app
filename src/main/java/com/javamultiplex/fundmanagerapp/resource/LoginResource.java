package com.javamultiplex.fundmanagerapp.resource;

import com.javamultiplex.fundmanagerapp.repository.UserRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class LoginResource {

    private UserRepository userRepository;
}
