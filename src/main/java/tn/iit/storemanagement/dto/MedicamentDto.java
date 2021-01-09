package tn.iit.storemanagement.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MedicamentDto {
    private long id;
    @NotNull
    @NotEmpty
    @Size(min = 3)
    private String nom;
    @NotNull
    private float prix;
    @NotNull
    private Date dateExpiration;
    @NotNull
    private long categotieId;
    @NotNull
    @Size(min = 3)
    private String categorieNom;
}
