package com.javamultiplex.fundmanagerapp.resource;

import com.javamultiplex.fundmanagerapp.entity.User;
import com.javamultiplex.fundmanagerapp.entity.UserContribution;
import com.javamultiplex.fundmanagerapp.model.UserContributionDTO;
import com.javamultiplex.fundmanagerapp.repository.UserContributionRepository;
import com.javamultiplex.fundmanagerapp.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class UserContributionResource {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserContributionRepository userContributionRepository;

    @PostMapping("/user-contribution")
    public ResponseEntity<String> addUserContribution(@RequestBody UserContributionDTO userContributionDTO){

        Long userId = userContributionDTO.getUserId();
        log.info("user id : [{}]",userId);
        Optional<User> user = userRepository.findById(userId);
        User user1=null;
        if (user.isPresent()){
            UserContribution userContribution=new UserContribution(userContributionDTO.getMonth(), userContributionDTO.getAmount());
            user1 = user.get();
            user1.addUserContribution(userContribution);
        }else{
            return new ResponseEntity<String>("User Id : "+userId+" is invalid", HttpStatus.BAD_REQUEST);
        }
        User result = userRepository.save(user1);
        log.info("User : [{}]",result);
        String message="User contribution has been added successfully";
        return new ResponseEntity<String>(message, HttpStatus.OK);
    }
}
