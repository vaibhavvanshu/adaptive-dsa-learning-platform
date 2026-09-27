package com.adaptive.backend.entity;

/**
 * @author ivek5
 **/


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "topic_weaknesses",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_weakness_user_topic_type",
                        columnNames = {"user_id", "topic_id", "weakness_type"}
                )
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TopicWeakness {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "user_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_weakness_user")
    )
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "topic_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_weakness_topic")
    )
    private Topic topic;

    @Enumerated(EnumType.STRING)
    @Column(name = "weakness_type", nullable = false, length = 30)
    private WeaknessType weaknessType;

    @Column(nullable = false)
    @Builder.Default
    private Integer occurrenceCount = 0;

    @Column(nullable = false)
    @Builder.Default
    private Double severityScore = 0.0;

    private LocalDateTime lastDetectedAt;

    public enum WeaknessType {
        OFF_BY_ONE,
        WRONG_ALGORITHM,
        POOR_COMPLEXITY,
        MISSED_EDGE_CASE,
        STATE_TRANSITION
    }
}
