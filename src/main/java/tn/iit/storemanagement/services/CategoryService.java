package tn.iit.storemanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.iit.storemanagement.dao.CategoryDao;
import tn.iit.storemanagement.dto.CategorieDto;
import tn.iit.storemanagement.mapper.CategoryMapper;

import javax.transaction.Transactional;
import java.util.Collection;

@Transactional
@Service
public class CategoryService {

    private final CategoryDao categoryDao;
    @Autowired
    public CategoryService(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public CategorieDto save(CategorieDto categorieDto) {
         this.categoryDao.saveAndFlush (CategoryMapper.categoryDtoToCategory (categorieDto));
         return categorieDto;
    }
    public void deleteById(Long id){
        this.categoryDao.deleteById (id);
    }
    public CategorieDto findOne(Long id){

        return CategoryMapper.categoryToCategoryDto (this.categoryDao.getOne (id));
    }
    public Collection<CategorieDto> findAll(){
        return CategoryMapper.categoriesToCategoriesDtos (this.categoryDao.findAll ());
    }
}
