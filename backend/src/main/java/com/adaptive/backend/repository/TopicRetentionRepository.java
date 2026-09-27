package com.adaptive.backend.repository;

/**
 * @author ivek5
 **/

import com.adaptive.backend.entity.Topic;
import com.adaptive.backend.entity.TopicRetention;
import com.adaptive.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TopicRetentionRepository extends JpaRepository<TopicRetention, Long> {

    Optional<TopicRetention> findByUserAndTopic(User user, Topic topic);

    List<TopicRetention> findByUserOrderByRetentionScoreAsc(User user);
}
