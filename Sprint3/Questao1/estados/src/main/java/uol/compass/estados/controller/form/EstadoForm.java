package uol.compass.estados.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import uol.compass.estados.model.Estado;
import uol.compass.estados.model.Regiao;
import uol.compass.estados.repository.RegiaoRepository;

public class EstadoForm {
    
    @NotNull @NotEmpty @Length(min = 5)
    private String nome;
    @NotNull @NotEmpty @Length(min = 5)
    private String capital;
    @NotNull @NotEmpty
    private String nomeRegiao;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCapital() {
        return capital;
    }
    public void setCapital(String capital) {
        this.capital = capital;
    }
    public String getRegiao() {
        return nomeRegiao;
    }
    public void setRegiao(String nomeRegiao) {
        this.nomeRegiao = nomeRegiao;
    }

    public Estado converter(RegiaoRepository regiaoRepository) {
        Regiao regiao = regiaoRepository.findByNomeRegiao(nomeRegiao);
        return new Estado(nome, regiao, capital);
    }
}
