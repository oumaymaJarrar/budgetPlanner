package com.app_proxy.budgetplanner.Dao;

import com.app_proxy.budgetplanner.Entities.Categorie;

import java.util.List;
import java.util.Optional;

public interface CategorieDao {
    List<Categorie> findAllCategories();
    void createCategorie (Categorie categorie);
    void deleteCategorie(Long categorieId);
    boolean existsById(Long categorieId);
    void updateCategorie (Categorie categorie);
    Optional<Categorie> findById(Long categorieId);
}
