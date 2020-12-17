package tn.iit.storemanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.iit.storemanagement.dao.MedicamentDao;
import tn.iit.storemanagement.models.Medicament;

import java.util.List;

@Service
public class MedicamentService {

    private final MedicamentDao medicamentDao;
    @Autowired
    public MedicamentService(MedicamentDao medicamentDao) {
        this.medicamentDao = medicamentDao;
    }

    public Medicament save(Medicament medicament) {
        return this.medicamentDao.saveAndFlush (medicament);
    }
    public void deleteById(Long id){
        this.medicamentDao.deleteById (id);
    }
    public Medicament findOne(Long id){
        return this.medicamentDao.getOne (id);
    }
    public List<Medicament> findAll(){
        return this.medicamentDao.findAll ();
    }
}
