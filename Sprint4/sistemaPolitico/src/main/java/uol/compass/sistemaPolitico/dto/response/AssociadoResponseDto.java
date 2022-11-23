package uol.compass.sistemapolitico.dto.response;

import java.time.LocalDate;

import org.springframework.data.domain.Page;

import uol.compass.sistemapolitico.entidades.Associado;
import uol.compass.sistemapolitico.enums.CargoPolitico;
import uol.compass.sistemapolitico.enums.Sexo;

public class AssociadoResponseDto {

    private Long id;
    private String nome;
    private CargoPolitico cargoPolitico;
    private LocalDate dataNascimento;
    private Sexo sexo;

    public AssociadoResponseDto(Associado associado) {
        this.id = associado.getId();
        this.nome = associado.getNome();
        this.cargoPolitico = associado.getCargoPolitico();
        this.dataNascimento = associado.getDataNascimento();
        this.sexo = associado.getSexo();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public CargoPolitico getCargoPolitico() {
        return cargoPolitico;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public static Page<AssociadoResponseDto> converter(Page<Associado> associados) {
        return associados.map(AssociadoResponseDto::new);
    }
}
