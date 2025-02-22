package com.rezende.learn.controllers;

import com.rezende.learn.dto.LikeCourseDTO;
import com.rezende.learn.services.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping(value = "/likes")
public class LikeController {

    @Autowired
    private LikeService likeService;

    @PostMapping
    public ResponseEntity<LikeCourseDTO> addLike(
            @RequestParam("userId") UUID userId, @RequestParam("courseId") UUID courseId) {
        LikeCourseDTO likeCourseDTO = likeService.addLike(userId, courseId);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(likeCourseDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(likeCourseDTO);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteLike(
            @RequestParam("userId") UUID userId, @RequestParam("courseId") UUID courseId) {
        String message = likeService.deleteLike(userId, courseId);
        return ResponseEntity.ok(message);
    }

    @GetMapping(value = "/isLike")
    public ResponseEntity<Boolean> isLike(
            @RequestParam("userId") UUID userId, @RequestParam("courseId") UUID courseId) {
        Boolean isLike = likeService.isLike(userId, courseId);
        return ResponseEntity.ok(isLike);
    }
}
