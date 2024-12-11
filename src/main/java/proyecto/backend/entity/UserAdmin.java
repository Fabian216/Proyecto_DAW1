package proyecto.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserAdmin {
    @Id
    private int id;
    private String nombre;
    private String apellido;
}
