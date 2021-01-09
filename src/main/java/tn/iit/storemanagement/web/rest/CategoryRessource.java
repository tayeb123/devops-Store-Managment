package tn.iit.storemanagement.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import tn.iit.storemanagement.dto.CategorieDto;
import tn.iit.storemanagement.services.CategoryService;

import javax.validation.Valid;
import java.util.Collection;

@CrossOrigin("*")
@RequestMapping(value = "/api/categories")
@RestController()
public class CategoryRessource {

    private final Logger logger= LoggerFactory.getLogger (CategoryRessource.class);
    private final CategoryService categoryService;

    public CategoryRessource(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("{id}")
    public CategorieDto findOne(@PathVariable("id") long id) {
        this.logger.debug ("Getting Category {}",id);
        return this.categoryService.findOne (id);
    }

    @GetMapping
    public Collection<CategorieDto> findAll(){
        this.logger.debug ("Getting all categories");
        return this.categoryService.findAll ();
    }

    @PostMapping
    public CategorieDto add(@Valid @RequestBody CategorieDto categorieDto){
        this.logger.debug ("Adding new Category {}", categorieDto.getNom());
        return this.categoryService.save (categorieDto);
    }

    @PutMapping
    public CategorieDto update(@Valid @RequestBody CategorieDto categorieDto){
        this.logger.debug ("Updating Category {} with {}", categorieDto.getId (), categorieDto.getNom());
        return this.categoryService.save (categorieDto);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") long id){
        this.logger.debug ("Deleting Category {}",id);
        this.categoryService.deleteById (id);
    }

}
