package com.javamultiplex.fundmanagerapp.resource;

import com.javamultiplex.fundmanagerapp.entity.Event;
import com.javamultiplex.fundmanagerapp.entity.Expenses;
import com.javamultiplex.fundmanagerapp.model.ExpenseDTO;
import com.javamultiplex.fundmanagerapp.repository.EventRepository;
import com.javamultiplex.fundmanagerapp.repository.ExpenseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@Slf4j
@CrossOrigin("*")
public class EventExpensesResource {

    @Autowired
    private EventRepository eventRepository;

    @PostMapping("/event-expense")
    public ResponseEntity<String> addExpense(@RequestBody ExpenseDTO expenseDTO) {
        Long eventId = expenseDTO.getEventId();
        log.info("Event id is [{}]", eventId);
        Optional<Event> event = eventRepository.findById(eventId);
        Event event1 = null;
        if (event.isPresent()) {
            Expenses expense = new Expenses(expenseDTO.getName(), expenseDTO.getAmount());
            event1 = event.get();
            event1.addExpenses(expense);
        } else {
            return new ResponseEntity<>("Please enter valid event Id", HttpStatus.BAD_REQUEST);
        }
        eventRepository.save(event1);
        log.info("Event - > [{}]", event1);
        return new ResponseEntity<>("Event expense has been added successfully", HttpStatus.OK);
    }

}
