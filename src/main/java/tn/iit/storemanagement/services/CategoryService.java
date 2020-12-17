package tn.iit.storemanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.iit.storemanagement.dao.CategoryDao;
import tn.iit.storemanagement.models.Category;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryDao categoryDao;
    @Autowired
    public CategoryService(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public Category save(Category category) {
        return this.categoryDao.saveAndFlush (category);
    }
    public void deleteById(Long id){
        this.categoryDao.deleteById (id);
    }
    public Category findOne(Long id){
        return this.categoryDao.getOne (id);
    }
    public List<Category> findAll(){
        return this.categoryDao.findAll ();
    }
}
