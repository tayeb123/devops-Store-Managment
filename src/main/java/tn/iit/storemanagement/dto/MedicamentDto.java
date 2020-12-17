package tn.iit.storemanagement.dto;

import lombok.*;
import tn.iit.storemanagement.models.Category;
import java.util.Date;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MedicamentDto {
    private String name;
    private float dosage;
    private float price;
    private Date expiredDate;
    private Category category;
}
