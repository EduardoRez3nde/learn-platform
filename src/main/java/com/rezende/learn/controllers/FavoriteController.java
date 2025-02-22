package com.rezende.learn.controllers;

import com.rezende.learn.dto.FavoriteDTO;
import com.rezende.learn.dto.UserAndFavoriteDTO;
import com.rezende.learn.services.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping(value = "/favorites")
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    @PostMapping(value = "/{courseId}")
    public ResponseEntity<FavoriteDTO> addFavorite(
            @RequestParam(value = "userId") UUID userId,
            @PathVariable(value = "courseId") UUID courseId) {

        FavoriteDTO dto = favoriteService.addFavorite(userId, courseId);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{courseId}")
                .buildAndExpand(dto.getUserId(), dto.getCourseId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping
    public ResponseEntity<UserAndFavoriteDTO> findFavorites(@RequestParam(value = "userId") UUID userId) {
        UserAndFavoriteDTO dto = favoriteService.findFavorites(userId);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteFavorite(
            @RequestParam(value = "userId") UUID userId,
            @RequestParam(value = "courseId") UUID courseId) {
        String message = favoriteService.deleteFavorite(userId, courseId);
        return ResponseEntity.ok(message);
    }

    @GetMapping(value = "/isFavorite")
    public ResponseEntity<Boolean> isFavorite(
            @RequestParam(value = "userId") UUID userId,
            @RequestParam(value = "courseId") UUID courseId) {
        Boolean isFavorite = favoriteService.isFavorite(userId, courseId);
        return ResponseEntity.ok(isFavorite);
    }
}
