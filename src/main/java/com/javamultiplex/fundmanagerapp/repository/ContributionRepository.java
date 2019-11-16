package com.javamultiplex.fundmanagerapp.repository;

import com.javamultiplex.fundmanagerapp.entity.Contribution;
import org.springframework.data.repository.CrudRepository;

public interface ContributionRepository extends CrudRepository<Contribution,Long> {
}
