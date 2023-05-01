package com.example.firdavselbektour.UI.entity;

import com.example.firdavselbektour.UI.entity.dto.TourRequestDTO;
import com.example.firdavselbektour.UI.entity.dto.TourResponseDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "tours")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TourEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private Double price;

    private int period;

    private UUID imgUUID;

    private String imgContentType;
}
