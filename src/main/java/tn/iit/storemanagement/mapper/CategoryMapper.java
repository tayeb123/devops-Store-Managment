package tn.iit.storemanagement.mapper;

import tn.iit.storemanagement.domain.Categorie;
import tn.iit.storemanagement.dto.CategorieDto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CategoryMapper {


    public static CategorieDto categoryToCategoryDto(Categorie categorie)
    {
        CategorieDto categorieDto = new CategorieDto();
        categorieDto.setId (categorie.getId ());
        categorieDto.setNom(categorie.getName ());
        return categorieDto;
    }

    public static Categorie categoryDtoToCategory(CategorieDto categorieDto)
    {
        Categorie categorie = new Categorie();
        categorie.setId (categorieDto.getId ());
        categorie.setName (categorieDto.getNom());
        return categorie;
    }

    public static Collection<CategorieDto> categoriesToCategoriesDtos(Collection<Categorie> categories)
    {
        List<CategorieDto> categorieDtoList = new ArrayList<> ();
        categories.forEach(category -> {
            categorieDtoList.add (categoryToCategoryDto (category));
        });
        return categorieDtoList;
    }
}
