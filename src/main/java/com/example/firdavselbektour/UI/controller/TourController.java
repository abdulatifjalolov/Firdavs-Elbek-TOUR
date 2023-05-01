package com.example.firdavselbektour.UI.controller;

import com.example.firdavselbektour.UI.entity.dto.TourRequestDTO;
import com.example.firdavselbektour.UI.service.TourService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/tour")
public class TourController {
    private final TourService tourService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(
            @RequestParam("image") MultipartFile image,
            @RequestParam("name") String name,
            @RequestParam("price") Double price,
            @RequestParam("period") Integer period
    ) {
        TourRequestDTO tourRequestDTO = new TourRequestDTO(name, price, period, image);
        tourService.create(tourRequestDTO);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> list() {
        return ResponseEntity.ok(tourService.list());
    }

    @PutMapping("/{imageUrl}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> update(
            @PathVariable String imageUrl,
            @RequestParam("image") MultipartFile image,
            @RequestParam("name") String name,
            @RequestParam("price") Double price,
            @RequestParam("period") Integer period
    ) {
        UUID imageUUID = null;
        if (imageUrl != null) {
            imageUUID = getImageUUID(imageUrl);
        }
        TourRequestDTO tourRequestDTO = new TourRequestDTO(name, price, period, image);
        return ResponseEntity.ok(tourService.update(imageUUID, tourRequestDTO));
    }

    @DeleteMapping("/{imageUrl}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(
            @PathVariable String imageUrl
    ) {
        UUID imageUUID = null;
        if (imageUrl != null) {
            imageUUID = getImageUUID(imageUrl);
        }
        tourService.delete(imageUUID);
    }

    private UUID getImageUUID(String imageUrl) {
        String[] split = imageUrl.split("\\.");
        String UUID = "";
        for (int i = 0; i < split.length - 1; i++) {
            UUID += (split[i]);
        }
        return java.util.UUID.fromString(UUID);
    }
}
