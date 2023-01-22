package entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="perro")
public class Perro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(name = "id_perro")
    private int id_perro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_dueno", referencedColumnName = "id_dueno")
    private Dueno dueno;

    @Getter
    @Setter
    @Column(name = "nombre_perro")
    private String nombre_perro;

    @Getter
    @Setter
    @Column(name = "raza")
    private String raza;

    public Perro(int id_perro, String nombre_perro, String raza) {
        this.id_perro = id_perro;
        this.nombre_perro = nombre_perro;
        this.raza = raza;
    }

    public Perro(Dueno dueno, String nombre_perro, String raza) {
        this.dueno = dueno;
        this.nombre_perro = nombre_perro;
        this.raza = raza;
    }
}
