package com.javamultiplex.fundmanagerapp.resource;

import com.javamultiplex.fundmanagerapp.entity.Contribution;
import com.javamultiplex.fundmanagerapp.repository.ContributionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@Slf4j
@CrossOrigin("*")
public class ContributionResource {

    @Autowired
    private ContributionRepository contributionRepository;

    @PostMapping("/contribution")
    public ResponseEntity<String> addContribution(@RequestBody Contribution contribution){
        Contribution contribution1 = contributionRepository.save(contribution);
        log.info("Contribution added -> [{}]",contribution1);
        return new ResponseEntity<String>("Contribution successfully added with contribution id -> "+contribution1.getId(), HttpStatus.OK);
    }
}
