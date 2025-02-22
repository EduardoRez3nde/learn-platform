package com.rezende.learn.services;

import com.rezende.learn.dto.FavoriteDTO;
import com.rezende.learn.dto.UserAndFavoriteDTO;
import com.rezende.learn.entities.Course;
import com.rezende.learn.entities.Favorite;
import com.rezende.learn.entities.User;
import com.rezende.learn.repositories.CourseRepository;
import com.rezende.learn.repositories.FavoriteRepository;
import com.rezende.learn.repositories.UserRepository;
import com.rezende.learn.services.exceptions.ResourceAlreadyExistsException;
import com.rezende.learn.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class FavoriteService {

    @Autowired
    private FavoriteRepository favoriteRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Transactional
    public FavoriteDTO addFavorite(UUID userId, UUID courseId) {
        // TODO: Buscar Usuario autenticado por id
        User user = userRepository.getReferenceById(userId);
        Course course = courseRepository.getReferenceById(courseId);
        Favorite favorite = Favorite.from(user, course);
        favoriteRepository.findById(favorite.getId())
                .ifPresentOrElse(f -> {
                   throw new ResourceAlreadyExistsException("Favorite already exists");
                }, () -> favoriteRepository.save(favorite));
        return FavoriteDTO.from(user.getId(), course.getId());
    }

    @Transactional(readOnly = true)
    public UserAndFavoriteDTO findFavorites(UUID userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User with id %s not found", userId));
        return UserAndFavoriteDTO.of(user);
    }
}
