package tn.iit.storemanagement.factory;

import tn.iit.storemanagement.domain.Category;
import tn.iit.storemanagement.dto.CategoryDto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CategoryFactory {


    public static CategoryDto categoryToCategoryDto(Category category)
    {
        CategoryDto categoryDto = new CategoryDto ();
        categoryDto.setId (category.getId ());
        categoryDto.setName (category.getName ());
        return categoryDto;
    }

    public static Category categoryDtoToCategory(CategoryDto categoryDto)
    {
        Category category = new Category ();
        category.setId (categoryDto.getId ());
        category.setName (categoryDto.getName ());
        return category;
    }

    public static Collection<CategoryDto> categoriesToCategoriesDtos(Collection<Category> categories)
    {
        List<CategoryDto> categoryDtoList = new ArrayList<> ();
        categories.forEach(category -> {
            categoryDtoList.add (categoryToCategoryDto (category));
        });
        return categoryDtoList;
    }
}
