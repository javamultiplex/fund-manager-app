package com.javamultiplex.fundmanagerapp.repository;

import com.javamultiplex.fundmanagerapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
