package com.rezende.learn.repositories;

import com.rezende.learn.entities.Favorite;
import com.rezende.learn.entities.User;
import com.rezende.learn.entities.pk.FavoritePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface FavoriteRepository extends JpaRepository<Favorite, FavoritePK> {
}


