package com.adaptive.backend.repository;

/**
 * @author ivek5
 **/

import com.adaptive.backend.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TopicRepository extends JpaRepository<Topic, Long> {

    Optional<Topic> findByName(String name);

    boolean existsByName(String name);
}