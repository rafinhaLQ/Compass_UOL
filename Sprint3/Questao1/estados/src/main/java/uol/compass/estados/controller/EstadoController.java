package uol.compass.estados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uol.compass.estados.controller.dto.EstadoDto;
import uol.compass.estados.model.Estado;
import uol.compass.estados.repository.EstadoRepository;

@RestController
@RequestMapping("/states")
public class EstadoController {
    
    @Autowired
    private EstadoRepository estadoRepository;

    @GetMapping
    public Page<EstadoDto> lista(@RequestParam(required = false) String regiao, 
        @PageableDefault(sort = {"populacao", "area"}, direction = Direction.DESC) Pageable paginacao) {
        
        if (regiao==null) {
            Page<Estado> estados = estadoRepository.findAll(paginacao);
            return EstadoDto.converter(estados);
        } else {
            Page<Estado> estados = estadoRepository.findByRegiao(regiao, paginacao);
            return EstadoDto.converter(estados);
        }
    }
}
