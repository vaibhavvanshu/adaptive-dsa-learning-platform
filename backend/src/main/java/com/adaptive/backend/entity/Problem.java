package com.adaptive.backend.entity;

/**
 * @author ivek5
 **/

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "problems")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Problem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Difficulty difficulty;

    @Column(length = 500)
    private String constraints;

    @Column(columnDefinition = "TEXT")
    private String expectedApproach;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "topic_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_problem_topic")
    )
    private Topic topic;

    public enum Difficulty {
        EASY,
        MEDIUM,
        HARD
    }
}