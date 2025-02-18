package com.rezende.learn.repositories;

import com.rezende.learn.entities.User;
import com.rezende.learn.entities.WatchTime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WatchTimeRepository extends JpaRepository<WatchTime, UUID> {}

