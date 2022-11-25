package uol.compass.sistemapolitico.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import uol.compass.sistemapolitico.entidades.Associado;
import uol.compass.sistemapolitico.entidades.Partido;
import uol.compass.sistemapolitico.enums.CargoPolitico;

public interface AssociadoRepository extends JpaRepository<Associado, Long> {

    Page<Associado> findAllByCargoPolitico(CargoPolitico cargo, Pageable paginacao);

    Page<Associado> findAllByPartidoId(Partido partido, Pageable paginacao);

}
