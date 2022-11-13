package uol.compass.estados.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import uol.compass.estados.model.Estado;
import uol.compass.estados.model.Regiao;

public class EstadoForm {
    
    @NotNull @NotEmpty @Length(min = 5)
    private String nome;
    @NotNull @NotEmpty @Length(min = 5)
    private String capital;
    @NotNull @NotEmpty
    private String nomeRegiao;
    @NotNull
    private Long populacao;
    @NotNull
    private Double area;

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
    public String getNomeRegiao() {
        return nomeRegiao;
    }
    public void setNomeRegiao(String nomeRegiao) {
        this.nomeRegiao = nomeRegiao;
    }

    public Long getPopulacao() {
        return populacao;
    }
    public void setPopulacao(Long populacao) {
        this.populacao = populacao;
    }
    public Double getArea() {
        return area;
    }
    public void setArea(Double area) {
        this.area = area;
    }

    public Estado converter() {
        Regiao regiao = Regiao.valueOf(nomeRegiao);
        return new Estado(nome, regiao, populacao, capital, area);
    }
}
