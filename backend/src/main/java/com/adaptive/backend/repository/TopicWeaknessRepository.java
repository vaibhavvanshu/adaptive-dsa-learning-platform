package com.adaptive.backend.repository;

/**
 * @author ivek5
 **/

import com.adaptive.backend.entity.Topic;
import com.adaptive.backend.entity.TopicWeakness;
import com.adaptive.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TopicWeaknessRepository extends JpaRepository<TopicWeakness, Long> {

    Optional<TopicWeakness> findByUserAndTopicAndWeaknessType(
            User user,
            Topic topic,
            TopicWeakness.WeaknessType weaknessType
    );

    List<TopicWeakness> findByUserOrderBySeverityScoreDesc(User user);

    List<TopicWeakness> findByUserAndTopic(
            User user,
            Topic topic
    );
}