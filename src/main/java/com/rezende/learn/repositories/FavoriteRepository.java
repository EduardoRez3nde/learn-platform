package com.rezende.learn.repositories;

import com.rezende.learn.entities.Favorite;
import com.rezende.learn.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FavoriteRepository extends JpaRepository<Favorite, UUID> { }


