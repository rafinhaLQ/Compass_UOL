package uol.compass.sistemapolitico.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import uol.compass.sistemapolitico.dto.pedido.AssociadoRequestDto;
import uol.compass.sistemapolitico.dto.resposta.AssociadoResponseDto;
import uol.compass.sistemapolitico.entidades.Associado;
import uol.compass.sistemapolitico.repository.AssociadoRepository;

@Service
@RequiredArgsConstructor
public class AssociadoServiceImpl implements AssociadoService {

    private final ModelMapper modelMapper;

    private final AssociadoRepository associadoRepository;

    @Override
    public AssociadoResponseDto cadastra(AssociadoRequestDto pedido) {
        Associado paraCriar = modelMapper.map(pedido, Associado.class);
        Associado criado = associadoRepository.save(paraCriar);
        AssociadoResponseDto resposta = modelMapper.map(criado, AssociadoResponseDto.class);

        return resposta;
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
