package com.rezende.learn.repositories;

import com.rezende.learn.entities.Course;
import com.rezende.learn.entities.Episode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EpisodeRepository extends JpaRepository<Episode, UUID> {
}
