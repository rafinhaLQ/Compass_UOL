package uol.compass.estados.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import uol.compass.estados.model.Regiao;

public interface RegiaoRepository extends JpaRepository<Regiao, String>{
    
    Regiao findByNomeRegiao(String nomeRegiao);
    
}
