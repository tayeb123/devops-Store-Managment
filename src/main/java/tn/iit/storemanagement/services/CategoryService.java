package tn.iit.storemanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.iit.storemanagement.dao.CategoryDao;
import tn.iit.storemanagement.domain.Category;
import tn.iit.storemanagement.dto.CategoryDto;
import tn.iit.storemanagement.factory.CategoryFactory;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Transactional
@Service
public class CategoryService {

    private final CategoryDao categoryDao;
    @Autowired
    public CategoryService(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public CategoryDto save(CategoryDto categoryDto) {
         this.categoryDao.saveAndFlush (CategoryFactory.categoryDtoToCategory (categoryDto));
         return categoryDto;
    }
    public void deleteById(Long id){
        this.categoryDao.deleteById (id);
    }
    public CategoryDto findOne(Long id){

        return CategoryFactory.categoryToCategoryDto (this.categoryDao.getOne (id));
    }
    public Collection<CategoryDto> findAll(){
        return CategoryFactory.categoriesToCategoriesDtos (this.categoryDao.findAll ());
    }
}
