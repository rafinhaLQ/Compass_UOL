package uol.compass.estados.controller;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import uol.compass.estados.controller.dto.EstadoDto;
import uol.compass.estados.controller.form.EstadoForm;
import uol.compass.estados.model.Estado;
import uol.compass.estados.model.Regiao;
import uol.compass.estados.repository.EstadoRepository;
import uol.compass.estados.repository.RegiaoRepository;

@RestController
@RequestMapping("/states")
public class EstadoController {
    
    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private RegiaoRepository regiaoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<EstadoDto> cadastrar(@RequestBody @Valid EstadoForm estadoForm, UriComponentsBuilder uriBuilder) {

        Estado estado = estadoForm.converter(regiaoRepository);
        estadoRepository.save(estado);

        URI uri = uriBuilder.path("/states/{id}").buildAndExpand(estado.getId()).toUri();
        return ResponseEntity.created(uri).body(new EstadoDto(estado));
        
    }

    @GetMapping
    public Page<EstadoDto> lista(@RequestParam(required = false) Regiao  regiao, 
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
