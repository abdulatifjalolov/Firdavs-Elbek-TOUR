package com.example.firdavselbektour.UI.entity.dto;

import com.example.firdavselbektour.UI.entity.TourEntity;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class TourResponseDTO {

    private String name;

    private Double price;

    private int period;

    private String imageUrl;

    public static TourResponseDTO of(TourEntity tourEntity) {
        return new TourResponseDTO(
                tourEntity.getName(),
                tourEntity.getPrice(),
                tourEntity.getPeriod(),
                tourEntity.getImgUUID() + tourEntity.getImgContentType()
        );
    }

}
