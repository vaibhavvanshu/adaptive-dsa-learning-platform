package com.adaptive.backend.service;

/**
 * @author ivek5
 **/

import com.adaptive.backend.entity.Attempt;
import com.adaptive.backend.entity.Problem;
import com.adaptive.backend.entity.User;
import com.adaptive.backend.repository.AttemptRepository;
import com.adaptive.backend.repository.ProblemRepository;
import com.adaptive.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttemptService {

    private final AttemptRepository attemptRepository;
    private final UserRepository userRepository;
    private final ProblemRepository problemRepository;

    public AttemptService(
            AttemptRepository attemptRepository,
            UserRepository userRepository,
            ProblemRepository problemRepository
    ) {
        this.attemptRepository = attemptRepository;
        this.userRepository = userRepository;
        this.problemRepository = problemRepository;
    }

    public Attempt createAttempt(
            Long userId,
            Long problemId,
            Attempt.SubmissionStatus status,
            Integer executionTimeMs,
            Integer memoryUsedKb,
            Attempt.ErrorType errorType,
            String errorDetails,
            String language,
            String submittedCode
    ) {

        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new RuntimeException("User not found with id: " + userId));

        Problem problem = problemRepository.findById(problemId)
                .orElseThrow(() ->
                        new RuntimeException("Problem not found with id: " + problemId));

        Attempt attempt = Attempt.builder()
                .user(user)
                .problem(problem)
                .status(status)
                .executionTimeMs(executionTimeMs)
                .memoryUsedKb(memoryUsedKb)
                .errorType(errorType)
                .errorDetails(errorDetails)
                .language(language)
                .submittedCode(submittedCode)
                .build();

        return attemptRepository.save(attempt);
    }

    public List<Attempt> getAttemptsByUser(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new RuntimeException("User not found with id: " + userId));

        return attemptRepository.findByUserOrderBySubmittedAtDesc(user);
    }

    public Attempt getAttemptById(Long id) {

        return attemptRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Attempt not found with id: " + id));
    }
}
