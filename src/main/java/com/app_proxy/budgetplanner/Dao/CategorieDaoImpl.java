package com.app_proxy.budgetplanner.Dao;

import com.app_proxy.budgetplanner.Entities.Categorie;
import com.app_proxy.budgetplanner.Repository.CategorieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class CategorieDaoImpl implements CategorieDao {
    private final CategorieRepository categorieRepository;

    public CategorieDaoImpl(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    @Override
    public List<Categorie> findAllCategories() {
        return categorieRepository.findAll();
    }

    @Override
    public void createCategorie(Categorie categorie) {
        categorieRepository.save(categorie);
    }

    @Override
    public void deleteCategorie(Long categorieId) {
        categorieRepository.deleteById(categorieId);
    }

    @Override
    public boolean existsById(Long categorieId) {
        return categorieRepository.existsById(categorieId);
    }

    @Override
    public void updateCategorie(Categorie categorie) {
        if (existsById(categorie.getId())){
            categorieRepository.save(categorie);
        }else {
            log.debug("Categorie with id {} does not exist to updating", categorie.getId());
        }

    }

    @Override
    public Optional<Categorie> findById(Long categorieId) {
        if (categorieRepository.existsById(categorieId)){
            return categorieRepository.findById(categorieId);
        }else {
            log.debug("Categorie with id {} does not exist", categorieId);
        }
        return Optional.empty();
    }

    /*



     */
}
