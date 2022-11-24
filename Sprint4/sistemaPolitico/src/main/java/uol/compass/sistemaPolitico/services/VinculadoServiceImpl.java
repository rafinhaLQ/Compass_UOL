package uol.compass.sistemapolitico.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uol.compass.sistemapolitico.dto.request.VinculadoRequestDto;
import uol.compass.sistemapolitico.dto.response.VinculadoResponseDto;
import uol.compass.sistemapolitico.entidades.Vinculado;
import uol.compass.sistemapolitico.repository.VinculadoRepository;

@Service
public class VinculadoServiceImpl implements VinculadoService {

    private VinculadoRepository repository;

    @Autowired
    public VinculadoServiceImpl(VinculadoRepository repository) {
        this.repository = repository;
    }

    @Override
    public VinculadoResponseDto vincula(VinculadoRequestDto request) {
        Vinculado paraCriar = request.converterParaVinculado();
        Vinculado criado = repository.save(paraCriar);

        return new VinculadoResponseDto(criado);
    }

}
