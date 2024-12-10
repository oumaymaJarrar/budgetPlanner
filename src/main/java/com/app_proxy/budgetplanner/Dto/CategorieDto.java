package com.app_proxy.budgetplanner.Dto;

import com.app_proxy.budgetplanner.Entities.Categorie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CategorieDto {
    private Long id;
    private String name;
    private BigDecimal amount;
    private String type;
    private Date dependency_date;
    private String description;
    private Instant createdAt;
    private Instant updatedAt;
//    public static CategorieDto makeCategorie(Categorie categorie) {
//        return  CategorieDto.builder()
//                .id(categorie.getId())
//                .name(categorie.getName())
//                .amount(categorie.getAmount())
//                .type(categorie.getType())
//                .dependency_date(categorie.getDependency_date())
//                .description(categorie.getDescription())
//                .createdAt(categorie.getCreatedAt())
//                .updatedAt(categorie.getUpdatedAt())
//                .build();
//    }
}
