package com.app_proxy.budgetplanner.Mapper;

import com.app_proxy.budgetplanner.Dto.CategorieDto;
import com.app_proxy.budgetplanner.Entities.Categorie;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategorieMapper {
    CategorieDto entityToMap(Categorie categorie);
    Categorie mapToEntity(CategorieDto categorieDto);
    List<CategorieDto> mapToListDto(List<Categorie> categories);

}
