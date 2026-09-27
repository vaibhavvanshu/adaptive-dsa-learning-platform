package com.adaptive.backend.entity;

/**
 * @author ivek5
 **/

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "attempts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Attempt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "user_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_attempt_user")
    )
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "problem_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_attempt_problem")
    )
    private Problem problem;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private SubmissionStatus status;

    @Column(nullable = false)
    private Integer executionTimeMs;

    @Column(nullable = false)
    private Integer memoryUsedKb;

    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private ErrorType errorType;

    @Column(columnDefinition = "TEXT")
    private String errorDetails;

    @Column(length = 100)
    private String language;

    @Column(columnDefinition = "TEXT")
    private String submittedCode;

    @Column(nullable = false, updatable = false)
    @Builder.Default
    private LocalDateTime submittedAt = LocalDateTime.now();

    public enum SubmissionStatus {
        ACCEPTED,
        WRONG_ANSWER,
        TIME_LIMIT_EXCEEDED,
        RUNTIME_ERROR,
        COMPILATION_ERROR
    }

    public enum ErrorType {
        OFF_BY_ONE,
        WRONG_ALGORITHM,
        POOR_COMPLEXITY,
        MISSED_EDGE_CASE,
        STATE_TRANSITION
    }
}
