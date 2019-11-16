package com.javamultiplex.fundmanagerapp.repository;

import com.javamultiplex.fundmanagerapp.entity.UserContribution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserContributionRepository extends JpaRepository<UserContribution, Long> {

}
