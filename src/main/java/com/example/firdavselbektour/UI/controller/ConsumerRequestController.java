package com.example.firdavselbektour.UI.controller;

import com.example.firdavselbektour.UI.entity.dto.ConsumerRequestDTO;
import com.example.firdavselbektour.UI.service.ConsumerRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/consumer-request")
@RequiredArgsConstructor
public class ConsumerRequestController {
    private final ConsumerRequestService consumerRequestService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(
            @RequestBody ConsumerRequestDTO consumerRequestDTO
    ) {
        consumerRequestService.create(consumerRequestDTO);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getList() {
        return ResponseEntity.ok(consumerRequestService.list());
    }
}
