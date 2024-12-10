package com.app_proxy.budgetplanner.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Rapport")
@Builder
public class Rapport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    Number total_revenue;
    Number total_expense;
    Number economy;
    String details;
    @CreationTimestamp
    private Instant createdAt;
    @UpdateTimestamp
    private Instant updatedAt;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
}
