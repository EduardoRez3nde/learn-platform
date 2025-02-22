package com.rezende.learn.services;

import com.rezende.learn.dto.CourseDTO;
import com.rezende.learn.dto.LikeCourseDTO;
import com.rezende.learn.entities.Course;
import com.rezende.learn.entities.Like;
import com.rezende.learn.entities.User;
import com.rezende.learn.repositories.CourseRepository;
import com.rezende.learn.repositories.LikeRepository;
import com.rezende.learn.repositories.UserRepository;
import com.rezende.learn.services.exceptions.ResourceAlreadyExistsException;
import com.rezende.learn.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class LikeService {

    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Transactional
    public LikeCourseDTO addLike(UUID userId, UUID courseId) {
        User user = userRepository.getReferenceById(userId);
        Course course = courseRepository.getReferenceById(courseId);
        Like like = Like.from(user, course);
        likeRepository.findById(like.getId())
                .ifPresentOrElse(l -> {
                    throw new ResourceAlreadyExistsException("Like already exists");
                }, () -> likeRepository.save(like));
        return LikeCourseDTO.from(user.getId(), user.fullName(), CourseDTO.of(course));
    }

    @Transactional
    public String deleteLike(UUID userId, UUID courseId) {
        User user = userRepository.getReferenceById(userId);
        Course course = courseRepository.getReferenceById(courseId);
        Like like = Like.from(user, course);

        likeRepository.findById(like.getId())
                .ifPresentOrElse(l -> likeRepository.delete(l), () -> {
                    throw new ResourceNotFoundException("Like not found");
                });
        return String.format("Like to course %s deleted", courseId);
    }
    
    @Transactional(readOnly = true)
    public Boolean isLike(UUID userId, UUID courseId) {
        User user = userRepository.getReferenceById(userId);
        Course course = courseRepository.getReferenceById(courseId);
        Like like = Like.from(user, course);
        return likeRepository.findById(like.getId()).isPresent();
    }
}
