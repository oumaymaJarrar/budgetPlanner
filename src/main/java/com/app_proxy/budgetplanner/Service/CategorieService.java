package com.app_proxy.budgetplanner.Service;

import com.app_proxy.budgetplanner.Dto.CategorieDto;

import java.util.List;

public interface CategorieService {
    List<CategorieDto> getAllCategories();
    boolean deleteCategorie(Long id);
    void createCategorie(CategorieDto categorieDto);
    void updateCategorie(CategorieDto categorieDto);
    CategorieDto getCategorieById(Long id);

}
