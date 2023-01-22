package entity;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.*;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data //Es de lombok para ahorrar codigo, genera constructores y getters y setters
@Entity
@Table(name = "dueno")
public class Dueno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(name = "id_dueno")
    private int id_dueno;

    @Getter
    @Setter
    @Column(name = "nombre_dueno")
    private String nombre_dueno;

    @Getter
    @Setter
    @Column(name = "apellido_dueno")
    private String apellido_dueno;

    @OneToMany(mappedBy="id_perro",cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private List<Perro> perros;

    public Dueno(String nombre_dueno, String apellido_dueno) {
        this.nombre_dueno = nombre_dueno;
        this.apellido_dueno = apellido_dueno;
    }
}
