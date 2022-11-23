package uol.compass.sistemapolitico.dto.request;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import uol.compass.sistemapolitico.entidades.Associado;
import uol.compass.sistemapolitico.enums.CargoPolitico;
import uol.compass.sistemapolitico.enums.Sexo;

public class AssociadoRequestDto {

    @NotNull @NotEmpty @Length(min = 5)
    private String nome;
    @NotNull @NotEmpty @Length(min = 5)
    private String nomeCargoPolitico;
    @NotNull @NotEmpty @Length(min = 9)
    private String dataNascimentoEmString;
    @NotNull @NotEmpty @Length(min = 7)
    private String sexoEmString;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeCargoPolitico() {
        return nomeCargoPolitico;
    }

    public void setNomeCargoPolitico(String nomeCargoPolitico) {
        this.nomeCargoPolitico = nomeCargoPolitico;
    }

    public String getDataNascimento() {
        return dataNascimentoEmString;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimentoEmString = dataNascimento;
    }

    public String getSexo() {
        return sexoEmString;
    }

    public void setSexo(String sexo) {
        this.sexoEmString = sexo;
    }

    public Associado converter() {
        CargoPolitico cargoPolitico = CargoPolitico.valueOf(nomeCargoPolitico);
        LocalDate dataNascimento = LocalDate.parse(dataNascimentoEmString);
        Sexo sexo = Sexo.valueOf(sexoEmString);
        return new Associado(nome, cargoPolitico, dataNascimento, sexo);
    }
}
