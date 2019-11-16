package com.javamultiplex.fundmanagerapp.repository;

import com.javamultiplex.fundmanagerapp.entity.User;
import com.javamultiplex.fundmanagerapp.entity.UserContribution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserContributionRepository extends JpaRepository<UserContribution, Long> {
}
