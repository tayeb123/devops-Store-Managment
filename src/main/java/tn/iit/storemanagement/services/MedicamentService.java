package tn.iit.storemanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.iit.storemanagement.dao.MedicamentDao;
import tn.iit.storemanagement.domain.Medicaments;
import tn.iit.storemanagement.dto.MedicamentDto;
import tn.iit.storemanagement.mapper.MedicamentMapper;
import tn.iit.storemanagement.web.rest.errors.ResourceNotFoundException;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

@Transactional
@Service
public class MedicamentService {

    private final MedicamentDao medicamentDao;
    @Autowired
    public MedicamentService(MedicamentDao medicamentDao) {
        this.medicamentDao = medicamentDao;
    }

    public MedicamentDto save(MedicamentDto medicamentDto) {
        this.medicamentDao.saveAndFlush (MedicamentMapper.medicamentDtoToMedicament (medicamentDto));
        return medicamentDto;
    }
    public void deleteById(Long id){
        this.medicamentDao.deleteById (id);
    }
    public MedicamentDto findOne(Long id){
        Optional<Medicaments> medicament=this.medicamentDao.findById (id);
        if(!medicament.isPresent ())
            throw new ResourceNotFoundException ("Medicament with id " + id + " not found");
        return MedicamentMapper.medicamentToMedicamentDto (medicament.get ());
    }
    public Collection<MedicamentDto> findAll(){
        return MedicamentMapper.medicamentsToMedicamentDtos (this.medicamentDao.findAll ());
    }
}
