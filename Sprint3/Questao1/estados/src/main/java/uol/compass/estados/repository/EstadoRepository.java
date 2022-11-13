package uol.compass.estados.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import uol.compass.estados.model.Estado;
import uol.compass.estados.model.Regiao;

public interface EstadoRepository extends JpaRepository<Estado, Long> {

    Page<Estado> findByRegiao(Regiao regiao, Pageable paginacao);
    
}
