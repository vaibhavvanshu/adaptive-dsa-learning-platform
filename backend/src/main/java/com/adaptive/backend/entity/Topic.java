package com.adaptive.backend.entity;

/**
 * @author ivek5
 **/

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
        name = "topics",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_topic_name", columnNames = "name")
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String name;

    @Column(length = 500)
    private String description;
}