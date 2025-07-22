package dev.java10x.CadastroDeNinjas.missoes;

public enum Ranking {

    RANK_S("rank S"),
    RANK_A("rank A"),
    RANK_B("rank B"),
    RANK_C("rank C"),
    RANK_D("rank D");

    private String nomeRank;

    Ranking(String nomeRank) {
        this.nomeRank = nomeRank;
    }

    public String getNomeRank() {
        return nomeRank;
    }

    public void setNomeRank(String nomeRank) {
        this.nomeRank = nomeRank;
    }

}
