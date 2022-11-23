package uol.compass.sistemapolitico.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Associado {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private CargoPolitico cargoPolitico;
    private LocalDate dataNascimento;
    private Sexo sexo;
}
