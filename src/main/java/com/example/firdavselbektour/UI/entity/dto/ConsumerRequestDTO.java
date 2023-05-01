package com.example.firdavselbektour.UI.entity.dto;

import com.example.firdavselbektour.UI.entity.ConsumerRequestEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ConsumerRequestDTO {
    private String fullName;
    private String phoneNumber;
    private String email;
    private String message;

    public static ConsumerRequestDTO of(ConsumerRequestEntity consumerRequestEntity) {
        return new ConsumerRequestDTO(
                consumerRequestEntity.getFullName(),
                consumerRequestEntity.getPhoneNumber(),
                consumerRequestEntity.getEmail(),
                consumerRequestEntity.getMessage()
        );
    }
}
