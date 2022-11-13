package uol.compass.estados.model;

import javax.persistence.Entity;

@Entity
public class Estado {
    
    private Long id;
    private String nome;
    private Regiao regiao;
    private Long população;
    private String capital;
    private Double area; 
}
