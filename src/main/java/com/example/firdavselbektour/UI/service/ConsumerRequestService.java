package com.example.firdavselbektour.UI.service;

import com.example.firdavselbektour.UI.entity.ConsumerRequestEntity;
import com.example.firdavselbektour.UI.entity.dto.ConsumerRequestDTO;
import com.example.firdavselbektour.UI.repository.ConsumerRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsumerRequestService {
    private final ConsumerRequestRepository consumerRequestRepository;

    public void create(ConsumerRequestDTO consumerRequestDTO) {
        consumerRequestRepository.save(
                ConsumerRequestEntity.of(consumerRequestDTO)
        );
    }

    public List<ConsumerRequestDTO> list() {
        List<ConsumerRequestDTO> response = new ArrayList<>();
        for (ConsumerRequestEntity consumerRequestEntity : consumerRequestRepository.findAll()) {
            response.add(ConsumerRequestDTO.of(consumerRequestEntity));
        }
        return response;
    }
}
