package com.app_proxy.budgetplanner.Service.Impl;

import com.app_proxy.budgetplanner.Dao.CategorieDao;
import com.app_proxy.budgetplanner.Dto.CategorieDto;
import com.app_proxy.budgetplanner.Entities.Categorie;
import com.app_proxy.budgetplanner.Mapper.CategorieMapper;
import com.app_proxy.budgetplanner.Service.CategorieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategorieServiceImpl implements CategorieService {
    private final CategorieDao categorieDao;
    private final CategorieMapper categorieMapper;
    @Override
    public List<CategorieDto> getAllCategories() {
        List<Categorie> categories = categorieDao.findAllCategories();
        if(!categories.isEmpty() && categories != null){
            return  categorieMapper.mapToListDto(categories);
        }
        else {
            return new ArrayList<>();
        }
    }

    @Override
    public boolean deleteCategorie(Long id) {
       if(categorieDao.existsById(id)) {
            categorieDao.deleteCategorie(id);
            return true;
       }
           return false;

    }

    @Override
    public void createCategorie(CategorieDto categorieDto ) {
      categorieDao.createCategorie(categorieMapper.mapToEntity(categorieDto));
    }

    @Override
    public void updateCategorie(CategorieDto categorieDto) {
        categorieDao.updateCategorie(categorieMapper.mapToEntity(categorieDto));
    }

    @Override
    public CategorieDto getCategorieById(Long id) {
        Optional<Categorie> categorie = categorieDao.findById(id);
        return categorieMapper.entityToMap(categorie.get());
    }
}
