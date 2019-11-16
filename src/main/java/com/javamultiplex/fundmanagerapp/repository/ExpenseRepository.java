package com.javamultiplex.fundmanagerapp.repository;

import com.javamultiplex.fundmanagerapp.entity.Expenses;
import org.springframework.data.repository.CrudRepository;

public interface ExpenseRepository extends CrudRepository<Expenses, Long> {
}
