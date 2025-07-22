package dev.java10x.CadastroDeNinjas.missoes;

import dev.java10x.CadastroDeNinjas.ninjas.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeMissao;
    private Ranking rankingDaMissao;

    // @OneToMany - Uma missão pode ter vários ninjas
    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninja;

    public MissoesModel() {
    }

    public MissoesModel(String nomeMissao, Ranking rankingDaMissao, NinjaModel ninja) {
        this.nomeMissao = nomeMissao;
        this.rankingDaMissao = rankingDaMissao;
        this.ninja = ninja;
    }

    public String getNomeMissao() {
        return nomeMissao;
    }

    public void setNomeMissao(String nomeMissao) {
        this.nomeMissao = nomeMissao;
    }

    public Ranking getRankingDaMissao() {
        return rankingDaMissao;
    }

    public void setRankingDaMissao(Ranking rankingDaMissao) {
        this.rankingDaMissao = rankingDaMissao;
    }

    public NinjaModel getNinja() {
        return ninja;
    }

    public void setNinja(NinjaModel ninja) {
        this.ninja = ninja;
    }
}

