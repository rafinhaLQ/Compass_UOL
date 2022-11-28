package uol.compass.sistemapolitico.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import uol.compass.sistemapolitico.entidades.Partido;
import uol.compass.sistemapolitico.enums.Ideologia;

public interface PartidoRepository extends JpaRepository<Partido, Long> {

    Page<Partido> findAllByIdeologia(Ideologia ideologia, Pageable paginacao);

}
