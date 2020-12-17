package tn.iit.storemanagement.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.iit.storemanagement.dto.MedicamentDto;
import tn.iit.storemanagement.models.Medicament;
import tn.iit.storemanagement.services.MedicamentService;

import java.util.List;

@CrossOrigin("*")
@RequestMapping(value = "/medicaments")
@RestController()
public class MedicamentController {

    private final Logger logger = LoggerFactory.getLogger (MedicamentController.class);
    private final MedicamentService medicamentService;

    @Autowired
    public MedicamentController(MedicamentService medicamentService) {
        this.medicamentService = medicamentService;
    }

    @GetMapping("/{id}")
    public Medicament findOne(@PathVariable("id") long id) {
        this.logger.debug ("Getting Medicament {}", id);
        return this.medicamentService.findOne (id);
    }

    @GetMapping("/all")
    public List<Medicament> findAll() {
        this.logger.debug ("Getting all medicaments");
        return this.medicamentService.findAll ();
    }

    @PostMapping("/add")
    public Medicament add(@RequestBody MedicamentDto medicamentDto) {
        this.logger.debug ("Adding new Medicament {}", medicamentDto);
        Medicament medicament = new Medicament (
                medicamentDto.getName (),
                medicamentDto.getDosage (),
                medicamentDto.getPrice (),
                medicamentDto.getExpiredDate (),
                medicamentDto.getCategory ());
        return this.medicamentService.save (medicament);
    }

    @PutMapping("/{id}")
    public Medicament update(@PathVariable("id") Long id, @RequestBody MedicamentDto medicamentDto) {
        this.logger.debug ("Updating Medicament {} with {}", id, medicamentDto);
        Medicament medicament = this.medicamentService.findOne (id);
        medicament.setName (medicamentDto.getName ());
        medicament.setDosage (medicamentDto.getDosage ());
        medicament.setPrice (medicamentDto.getPrice ());
        medicament.setExpiredDate (medicamentDto.getExpiredDate ());
        medicament.setCategory (medicamentDto.getCategory ());
        return this.medicamentService.save (medicament);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        this.logger.debug ("Deleting Medicament {}", id);
        this.medicamentService.deleteById (id);
    }
}