package tn.iit.storemanagement.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.iit.storemanagement.dto.CategoryDto;
import tn.iit.storemanagement.models.Category;
import tn.iit.storemanagement.services.CategoryService;

import java.util.List;

@CrossOrigin("*")
@RequestMapping(value = "/categories")
@RestController()
public class CategoryController {

    private final Logger logger= LoggerFactory.getLogger (CategoryController.class);
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("{id}")
    public Category findOne(@PathVariable("id") long id) {
        this.logger.debug ("Getting Category {}",id);
        return this.categoryService.findOne (id);
    }

    @GetMapping("/all")
    public List<Category> findAll(){
        this.logger.debug ("Getting all categories");
        return this.categoryService.findAll ();
    }

    @PostMapping("/add")
    public Category add(@RequestBody CategoryDto categoryDto){
        this.logger.debug ("Adding new Category {}",categoryDto.getName ());
        Category category = new Category (categoryDto.getName ());
        return this.categoryService.save (category);
    }

    @PutMapping("{id}")
    public Category update(@PathVariable("id") Long id,@RequestBody CategoryDto categoryDto){
        this.logger.debug ("Updating Category {} with {}",id,categoryDto.getName ());
        Category category=this.categoryService.findOne (id);
        category.setName (categoryDto.getName ());
        return this.categoryService.save (category);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") long id){
        this.logger.debug ("Deleting Category {}",id);
        this.categoryService.deleteById (id);
    }

}
