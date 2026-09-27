package com.adaptive.backend.dto;

/**
 * @author ivek5
 **/

import com.adaptive.backend.entity.Attempt;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class AttemptResponse {

    private Long id;

    private Long userId;
    private Long problemId;

    private Attempt.SubmissionStatus status;

    private Integer executionTimeMs;
    private Integer memoryUsedKb;

    private Attempt.ErrorType errorType;
    private String errorDetails;

    private String language;
    private String submittedCode;

    private LocalDateTime submittedAt;
}
