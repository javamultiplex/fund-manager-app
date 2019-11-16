package com.javamultiplex.fundmanagerapp.resource;

import com.javamultiplex.fundmanagerapp.entity.Event;
import com.javamultiplex.fundmanagerapp.repository.EventRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class EventResource {

    @Autowired
    private EventRepository eventRepository;

    @PostMapping("/event")
    public ResponseEntity<String> addEvent(@RequestBody Event event) {
        Event result = eventRepository.save(event);
        log.info("Event added [{}]", event);
        return new ResponseEntity<String>("Event successfully added with event Id -> " + result.getId(), HttpStatus.OK);
    }
}
