package uol.compass.estados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uol.compass.estados.controller.dto.EstadoDto;
import uol.compass.estados.repository.EstadoRepository;

@RestController
@RequestMapping("/states")
public class EstadoController {
    
    @Autowired
    private EstadoRepository estadoRepository;

    @GetMapping
    public Page<EstadoDto> lista() {
        
    }
}
