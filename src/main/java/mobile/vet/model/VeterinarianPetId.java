package mobile.vet.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
public class VeterinarianPetId implements Serializable {
    private Long veterinarianId;
    private Long petId;

}
