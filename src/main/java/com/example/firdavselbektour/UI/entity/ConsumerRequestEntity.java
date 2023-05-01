package com.example.firdavselbektour.UI.entity;

import com.example.firdavselbektour.UI.entity.dto.ConsumerRequestDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "requests")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ConsumerRequestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String phoneNumber;
    private String email;
    private String message;

    public static ConsumerRequestEntity of(ConsumerRequestDTO consumerRequestDTO) {
        return ConsumerRequestEntity.builder()
                .fullName(consumerRequestDTO.getFullName())
                .email(consumerRequestDTO.getEmail())
                .message(consumerRequestDTO.getMessage())
                .phoneNumber(consumerRequestDTO.getPhoneNumber())
                .build();
    }
}
