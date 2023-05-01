package com.example.firdavselbektour.UI.service;

import com.example.firdavselbektour.UI.entity.TourEntity;
import com.example.firdavselbektour.UI.entity.dto.TourRequestDTO;
import com.example.firdavselbektour.UI.entity.dto.TourResponseDTO;
import com.example.firdavselbektour.UI.repository.TourRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.*;


@Service
@RequiredArgsConstructor
public class TourService {
    private final TourRepository tourRepository;

    public void create(TourRequestDTO tourRequestDTO) {
        TourEntity tourEntity = saveImage(tourRequestDTO);
        tourRepository.save(tourEntity);
    }

    public List<TourResponseDTO> list() {
        List<TourEntity> tourEntityList = tourRepository.findAll();

        List<TourResponseDTO> response = new ArrayList<>();
        for (TourEntity tourEntity : tourEntityList) {
            response.add(TourResponseDTO.of(tourEntity));
        }
        return response;
    }

    public TourResponseDTO update(UUID imageUUID, TourRequestDTO tourRequestDTO) {
        Optional<TourEntity> optionalTourEntity = tourRepository.findByImgUUID(imageUUID);
        if (optionalTourEntity.isPresent()) {
            FileUtils.deleteImage(optionalTourEntity.get());
            int oldId = optionalTourEntity.get().getId();
            TourEntity tourEntity = saveImage(tourRequestDTO);
            tourEntity.setId(oldId);
            TourEntity newTourEntity = tourRepository.save(tourEntity);
            return TourResponseDTO.of(newTourEntity);
        }
        return null;
    }

    private TourEntity saveImage(TourRequestDTO tourRequestDTO) {
        MultipartFile image = tourRequestDTO.getImage();
        String[] split = Objects.requireNonNull(image.getOriginalFilename()).split("\\.");
        String imageContentType = "." + split[split.length - 1];

        UUID imageUUID = UUID.randomUUID();

        FileUtils.saveImage(image, imageUUID, imageContentType);
        return TourEntity.builder()
                .period(tourRequestDTO.getPeriod())
                .name(tourRequestDTO.getName())
                .price(tourRequestDTO.getPrice())
                .imgUUID(imageUUID)
                .imgContentType(imageContentType)
                .build();
    }

    public void delete(UUID imageUUID) {
        Optional<TourEntity> optionalTourEntity = tourRepository.findByImgUUID(imageUUID);
        if (optionalTourEntity.isPresent()) {
            TourEntity tourEntity = optionalTourEntity.get();
            FileUtils.deleteImage(tourEntity);
            tourRepository.deleteById(tourEntity.getId());
        }
    }
}
