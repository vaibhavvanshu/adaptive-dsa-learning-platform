package com.adaptive.backend.entity;

/**
 * @author ivek5
 **/


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "topic_retention",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_retention_user_topic",
                        columnNames = {"user_id", "topic_id"}
                )
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TopicRetention {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "user_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_retention_user")
    )
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "topic_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_retention_topic")
    )
    private Topic topic;

    @Column(nullable = false)
    @Builder.Default
    private Double retentionScore = 0.0;

    @Column(nullable = false)
    @Builder.Default
    private Integer practiceCount = 0;

    @Column(nullable = false)
    @Builder.Default
    private Integer successfulAttemptCount = 0;

    private LocalDateTime lastPracticedAt;

    private LocalDateTime nextReviewAt;
}
