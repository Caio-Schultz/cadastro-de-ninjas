package dev.java10x.CadastroDeNinjas.missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    // Criar uma missão
    public MissoesModel criarMissao(MissoesModel missao){
        return missoesRepository.save(missao);
    }

    // Listar todas as missões
    public List<MissoesModel> listarMissoes(){
        return missoesRepository.findAll();
    }

    // Listar missão por id
    public MissoesModel listarMissaoPorId(Long id){
        Optional<MissoesModel> missao = missoesRepository.findById(id);
        return missao.orElse(null);
    }

    // Deletar missão
    public void deletarMissaoPorId(Long id){
        missoesRepository.deleteById(id);
    }


}
