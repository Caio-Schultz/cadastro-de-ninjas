package dev.java10x.CadastroDeNinjas.missoes;

import dev.java10x.CadastroDeNinjas.ninjas.NinjaModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {

    private final MissoesRepository missoesRepository;
    private final MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    // Criar uma missão
    public MissoesDTO criarMissao(MissoesDTO missaoDTO){
        MissoesModel missoesModel = missoesMapper.map(missaoDTO);
        missoesModel = missoesRepository.save(missoesModel);
        return missoesMapper.map(missoesModel);
    }

    // Listar todas as missões
    public List<MissoesDTO> listarMissoes(){
        List<MissoesModel> missoes = missoesRepository.findAll();
        return missoes.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }

    // Listar missão por id
    public MissoesDTO listarMissaoPorId(Long id){
        Optional<MissoesModel> missao = missoesRepository.findById(id);
        return missao.map(missoesMapper::map).orElse(null);
    }

    // Deletar missão
    public void deletarMissaoPorId(Long id){
        missoesRepository.deleteById(id);
    }

    // Atualizar missão
    public MissoesDTO atualizarMissaoPorId(Long id, MissoesDTO missaoDTO){
        Optional<MissoesModel> missaoExistente = missoesRepository.findById(id);
        if(missaoExistente.isPresent()){
            MissoesModel missaoAtualizada = missoesMapper.map(missaoDTO);
            missaoAtualizada.setId(id);
            MissoesModel missaoSalva = missoesRepository.save(missaoAtualizada);
            return missoesMapper.map(missaoSalva);
        }
        return null;
    }


}
