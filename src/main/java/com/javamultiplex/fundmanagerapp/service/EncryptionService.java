package com.javamultiplex.fundmanagerapp.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class EncryptionService {

    public String encrypt(String password){
        return BCrypt.hashpw(password,BCrypt.gensalt(16));
    }

    public boolean validate(String plainPassword, String hashedPassword){
        return BCrypt.checkpw(plainPassword,hashedPassword);
    }
}
