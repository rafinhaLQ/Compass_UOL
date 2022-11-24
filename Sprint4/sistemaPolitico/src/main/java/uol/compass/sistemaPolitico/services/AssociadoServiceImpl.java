package uol.compass.sistemapolitico.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import uol.compass.sistemapolitico.dto.request.AssociadoRequestDto;
import uol.compass.sistemapolitico.dto.response.AssociadoResponseDto;
import uol.compass.sistemapolitico.entidades.Associado;
import uol.compass.sistemapolitico.repository.AssociadoRepository;

@Service
public class AssociadoServiceImpl implements AssociadoService {

    private AssociadoRepository associadoRepository;

    @Autowired
    public AssociadoServiceImpl(AssociadoRepository associadoRepository) {
        this.associadoRepository = associadoRepository;
    }

    @Override
    public AssociadoResponseDto cadastra(AssociadoRequestDto request) {
        Associado paraCriar = request.converterParaAssociado();
        Associado criado = associadoRepository.save(paraCriar);

        return new AssociadoResponseDto(criado);
    }

    @Override
    public Page<AssociadoResponseDto> listar(Pageable pageable) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public AssociadoResponseDto buscarPorId(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public AssociadoResponseDto alterar(Long id, AssociadoRequestDto request) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deletar(Long id) {
        // TODO Auto-generated method stub
        
    }

}
