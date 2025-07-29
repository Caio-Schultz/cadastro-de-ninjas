package dev.java10x.CadastroDeNinjas.missoes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.java10x.CadastroDeNinjas.ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeMissao;
    @Enumerated(EnumType.STRING)
    private Ranking rankingDaMissao;

    // @OneToMany - Uma missão pode ter vários ninjas
    @OneToMany(mappedBy = "missoes")
    // Essa anotação serve para evitar um loop por conta da serialização
    @JsonIgnore
    private List<NinjaModel> ninja;

}

