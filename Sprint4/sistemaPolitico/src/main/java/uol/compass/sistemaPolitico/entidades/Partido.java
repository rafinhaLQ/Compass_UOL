package uol.compass.sistemapolitico.entidades;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import uol.compass.sistemapolitico.enums.Ideologia;

@Entity
public class Partido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sigla;
    @Enumerated(EnumType.STRING)
    private Ideologia ideologia;
    private LocalDate dataFundacao;

}
