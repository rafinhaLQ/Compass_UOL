package uol.compass.estados.controller.dto;

import org.springframework.data.domain.Page;

import uol.compass.estados.model.Estado;

public class EstadoDto {
    
    private Long id;
    private String nome;
    private String capital;
    
    public EstadoDto(Estado estado) {
        this.id = estado.getId();
        this.nome = estado.getNome();
        this.capital = estado.getCapital();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCapital() {
        return capital;
    }

    public static Page<EstadoDto> converter(Page<Estado> estados) {
        return estados.map(EstadoDto::new);
    }
    
}
