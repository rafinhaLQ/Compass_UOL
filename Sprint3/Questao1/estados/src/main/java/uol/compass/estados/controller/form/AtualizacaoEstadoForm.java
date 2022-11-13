package uol.compass.estados.controller.form;

import javax.validation.constraints.NotNull;

import uol.compass.estados.model.Estado;
import uol.compass.estados.repository.EstadoRepository;

public class AtualizacaoEstadoForm {
    
    @NotNull
    private Long populacao;

    public Long getPopulacao() {
        return populacao;
    }

    public void setPopulacao(Long populacao) {
        this.populacao = populacao;
    }

    public Estado atualizar(Long id, EstadoRepository estadoRepository) {
        Estado estado = estadoRepository.getReferenceById(id);
        estado.setPopulacao(populacao);
        return estado;
    }
}
