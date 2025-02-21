package com.rezende.learn.repositories;

import com.rezende.learn.entities.User;
import com.rezende.learn.entities.WatchTime;
import com.rezende.learn.entities.pk.WatchTimePK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface WatchTimeRepository extends JpaRepository<WatchTime, WatchTimePK> {
}

