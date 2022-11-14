package uol.compass.estados.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import uol.compass.estados.model.Estado;
import uol.compass.estados.repository.EstadoRepository;

public class AtualizacaoEstadoForm {
    
    @NotNull @NotEmpty @Length(min = 5)
    private String capital;
    @NotNull
    private Long populacao;

    public Long getPopulacao() {
        return populacao;
    }

    public void setPopulacao(Long populacao) {
        this.populacao = populacao;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public Estado atualizar(Long id, EstadoRepository estadoRepository) {
        Estado estado = estadoRepository.getReferenceById(id);
        estado.setPopulacao(populacao);
        estado.setCapital(capital);
        return estado;
    }
    
}
