package uol.compass.estados.controller.dto;

import uol.compass.estados.model.Estado;
import uol.compass.estados.model.Regiao;

public class DetalhesDoEstadoDto {
    
    private Long id;
    private String nome;
    private Regiao regiao;
    private Long populacao;
    private String capital;
    private Double area;
    
    public DetalhesDoEstadoDto(Estado estado) {
        this.id = estado.getId();
        this.nome = estado.getNome();
        this.regiao = estado.getRegiao();
        this.populacao = estado.getPopulacao();
        this.capital = estado.getCapital();
        this.area = estado.getArea();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Regiao getRegiao() {
        return regiao;
    }

    public Long getPopulacao() {
        return populacao;
    }

    public String getCapital() {
        return capital;
    }

    public Double getArea() {
        return area;
    }

}
