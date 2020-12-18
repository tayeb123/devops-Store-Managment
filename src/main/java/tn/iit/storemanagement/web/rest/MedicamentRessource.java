package tn.iit.storemanagement.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.iit.storemanagement.dto.MedicamentDto;
import tn.iit.storemanagement.services.MedicamentService;

import javax.validation.Valid;
import java.util.Collection;

@CrossOrigin("*")
@RequestMapping(value = "/api/medicaments")
@RestController()
public class MedicamentRessource {

    private final Logger logger = LoggerFactory.getLogger (MedicamentRessource.class);
    private final MedicamentService medicamentService;

    public MedicamentRessource(MedicamentService medicamentService) {
        this.medicamentService = medicamentService;
    }

    @GetMapping("/{id}")
    public MedicamentDto findOne(@PathVariable("id") long id) {
        this.logger.debug ("Getting Medicament {}", id);
        return this.medicamentService.findOne (id);
    }

    @GetMapping()
    public Collection<MedicamentDto> findAll() {
        this.logger.debug ("Getting all medicaments");
        return this.medicamentService.findAll ();
    }

    @PostMapping
    public MedicamentDto add(@Valid @RequestBody MedicamentDto medicamentDto) {
        this.logger.debug ("Adding new Medicament {}", medicamentDto);

        return this.medicamentService.save (medicamentDto);
    }

    @PutMapping()
    public MedicamentDto update(@Valid @RequestBody MedicamentDto medicamentDto) {
        this.logger.debug ("Updating Medicament {} with {}", medicamentDto.getId (), medicamentDto);
        return this.medicamentService.save (medicamentDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        this.logger.debug ("Deleting Medicament {}", id);
        this.medicamentService.deleteById (id);
    }
}