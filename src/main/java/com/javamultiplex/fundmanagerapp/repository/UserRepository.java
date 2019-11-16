package com.javamultiplex.fundmanagerapp.repository;

import com.javamultiplex.fundmanagerapp.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
