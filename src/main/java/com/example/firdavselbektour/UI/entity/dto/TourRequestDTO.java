package com.example.firdavselbektour.UI.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
public class TourRequestDTO {

    private String name;

    private Double price;

    private int period;

    private MultipartFile image;

}
