package com.adaptive.backend.repository;

/**
 * @author ivek5
 **/

import com.adaptive.backend.entity.Problem;
import com.adaptive.backend.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProblemRepository extends JpaRepository<Problem, Long> {

    List<Problem> findByTopic(Topic topic);

    List<Problem> findByDifficulty(Problem.Difficulty difficulty);

    List<Problem> findByTopicAndDifficulty(
            Topic topic,
            Problem.Difficulty difficulty
    );
}