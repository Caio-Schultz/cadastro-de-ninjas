package dev.java10x.CadastroDeNinjas.missoes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MissoesDTO {

    private Long id;
    private String nomeMissao;
    private Ranking rankingDaMissao;


}
