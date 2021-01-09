package tn.iit.storemanagement.mapper;

import tn.iit.storemanagement.domain.Medicaments;
import tn.iit.storemanagement.dto.CategorieDto;
import tn.iit.storemanagement.dto.MedicamentDto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MedicamentMapper {

    public static MedicamentDto medicamentToMedicamentDto(Medicaments medicaments)
    {
        MedicamentDto medicamentDto = new MedicamentDto ();
        medicamentDto.setId (medicaments.getId ());
        medicamentDto.setCategorieNom(medicaments.getCategorie ().getName ());
        medicamentDto.setCategotieId(medicaments.getCategorie ().getId ());
        medicamentDto.setDateExpiration(medicaments.getDateExpiration ());
        medicamentDto.setPrix(medicaments.getPrix ());
        medicamentDto.setNom(medicaments.getNom());
        return medicamentDto;
    }

    public static Medicaments medicamentDtoToMedicament(MedicamentDto medicamentDto)
    {
        Medicaments medicaments = new Medicaments();
        medicaments.setId (medicamentDto.getId ());
        //TODO:Verify if Category Exists or no
        CategorieDto categorieDto =new CategorieDto(medicamentDto.getCategotieId(),medicamentDto.getCategorieNom());
        medicaments.setCategorie (CategoryMapper.categoryDtoToCategory (categorieDto));
        medicaments.setDateExpiration (medicamentDto.getDateExpiration());
        medicaments.setPrix (medicamentDto.getPrix());
        medicaments.setNom(medicamentDto.getNom());
        return medicaments;
    }

    public static Collection<MedicamentDto> medicamentsToMedicamentDtos(Collection<Medicaments> medicaments)
    {
        List<MedicamentDto> medicamentDtoList = new ArrayList<> ();
        medicaments.forEach(medicament -> {
            medicamentDtoList.add (medicamentToMedicamentDto (medicament));
        });
        return medicamentDtoList;
    }
}
