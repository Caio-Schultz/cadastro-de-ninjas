package dev.java10x.CadastroDeNinjas.missoes;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    // Listar todos os ninjas
    public List<MissoesModel> listarMissoes(){
        return missoesRepository.findAll();
    }


}
