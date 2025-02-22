package com.rezende.learn.repositories;

import com.rezende.learn.entities.Like;
import com.rezende.learn.entities.User;
import com.rezende.learn.entities.pk.LikePK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LikeRepository extends JpaRepository<Like, LikePK> { }

