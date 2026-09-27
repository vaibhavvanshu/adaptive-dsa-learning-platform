package com.adaptive.backend.repository;

/**
 * @author ivek5
 **/

import com.adaptive.backend.entity.Attempt;
import com.adaptive.backend.entity.User;
import com.adaptive.backend.entity.Problem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttemptRepository extends JpaRepository<Attempt, Long> {

    List<Attempt> findByUserOrderBySubmittedAtDesc(User user);

    List<Attempt> findByProblemOrderBySubmittedAtDesc(Problem problem);

    List<Attempt> findByUserAndProblemOrderBySubmittedAtDesc(
            User user,
            Problem problem
    );

    List<Attempt> findByUserAndStatus(
            User user,
            Attempt.SubmissionStatus status
    );

    List<Attempt> findByUserAndErrorType(
            User user,
            Attempt.ErrorType errorType
    );
}
