package com.app_proxy.budgetplanner.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="balance")
@Builder
public class Balance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    Number amount;
    Date modified_date;
    @CreationTimestamp
    private Instant createdAt;
    @UpdateTimestamp
    private Instant updatedAt;
    @OneToOne
    @JoinColumn(name= "user_id")
    private User user;

    @OneToMany (mappedBy = "balance")
    private List<Income> income;

    @OneToMany (mappedBy = "balance")
    private List<Expense> expense;

}
