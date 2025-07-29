package dev.java10x.CadastroDeNinjas.missoes;

import org.springframework.stereotype.Component;

@Component
public class MissoesMapper {

    public MissoesModel map(MissoesDTO missoesDTO){
        MissoesModel missoesModel = new MissoesModel();
        missoesModel.setId(missoesDTO.getId());
        missoesModel.setNomeMissao(missoesDTO.getNomeMissao());
        missoesModel.setRankingDaMissao(missoesDTO.getRankingDaMissao());

        return missoesModel;
    }

    public MissoesDTO map(MissoesModel missoesModel){
        MissoesDTO missoesDTO = new MissoesDTO();
        missoesDTO.setId(missoesModel.getId());
        missoesDTO.setNomeMissao(missoesModel.getNomeMissao());
        missoesDTO.setRankingDaMissao(missoesModel.getRankingDaMissao());

        return missoesDTO;
    }

}
