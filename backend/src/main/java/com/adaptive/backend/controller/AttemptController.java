package com.adaptive.backend.controller;

/**
 * @author ivek5
 **/

import com.adaptive.backend.dto.AttemptResponse;
import com.adaptive.backend.entity.Attempt;
import com.adaptive.backend.service.AttemptService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attempts")
public class AttemptController {

    private final AttemptService attemptService;

    public AttemptController(AttemptService attemptService) {
        this.attemptService = attemptService;
    }

    @PostMapping
    public AttemptResponse createAttempt(
            @RequestParam Long userId,
            @RequestParam Long problemId,
            @RequestParam Attempt.SubmissionStatus status,
            @RequestParam Integer executionTimeMs,
            @RequestParam Integer memoryUsedKb,
            @RequestParam(required = false) Attempt.ErrorType errorType,
            @RequestParam(required = false) String errorDetails,
            @RequestParam(required = false) String language,
            @RequestParam(required = false) String submittedCode
    ) {

        Attempt attempt = attemptService.createAttempt(
                userId,
                problemId,
                status,
                executionTimeMs,
                memoryUsedKb,
                errorType,
                errorDetails,
                language,
                submittedCode
        );

        return toResponse(attempt);
    }

    @GetMapping("/user/{userId}")
    public List<AttemptResponse> getAttemptsByUser(
            @PathVariable Long userId
    ) {

        return attemptService.getAttemptsByUser(userId)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public AttemptResponse getAttemptById(
            @PathVariable Long id
    ) {

        return toResponse(attemptService.getAttemptById(id));
    }

    private AttemptResponse toResponse(Attempt attempt) {

        return new AttemptResponse(
                attempt.getId(),
                attempt.getUser().getId(),
                attempt.getProblem().getId(),
                attempt.getStatus(),
                attempt.getExecutionTimeMs(),
                attempt.getMemoryUsedKb(),
                attempt.getErrorType(),
                attempt.getErrorDetails(),
                attempt.getLanguage(),
                attempt.getSubmittedCode(),
                attempt.getSubmittedAt()
        );
    }
}