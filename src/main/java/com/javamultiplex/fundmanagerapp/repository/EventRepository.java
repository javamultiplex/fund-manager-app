package com.javamultiplex.fundmanagerapp.repository;

import com.javamultiplex.fundmanagerapp.entity.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event,Long> {
}
