package uol.compass.sistemapolitico.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uol.compass.sistemapolitico.repository.AssociadoRepository;

@RestController
@RequestMapping("/associados")
public class AssociadoController {
    
    private AssociadoRepository associadoRepository;
    

}
