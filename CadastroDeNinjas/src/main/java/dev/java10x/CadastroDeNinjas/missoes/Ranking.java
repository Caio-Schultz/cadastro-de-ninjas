package dev.java10x.CadastroDeNinjas.missoes;

public enum Ranking {

    RANK_S("rank S", "Elite"),
    RANK_A("rank A", "Alto"),
    RANK_B("rank B", "Médio"),
    RANK_C("rank C", "Baixo"),
    RANK_D("rank D", "Iniciante");

    private String nomeRank;
    private String nivelRank;

    Ranking(String nomeRank, String nivelRank) {
        this.nomeRank = nomeRank;
        this.nivelRank = nivelRank;
    }

    public String getNomeRank() {
        return nomeRank;
    }

    public void setNomeRank(String nomeRank) {
        this.nomeRank = nomeRank;
    }

    public String getNivelRank() {
        return nivelRank;
    }

    public void setNivelRank(String nivelRank) {
        this.nivelRank = nivelRank;
    }

}
