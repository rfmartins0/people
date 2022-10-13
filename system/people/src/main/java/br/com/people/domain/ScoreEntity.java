package br.com.people.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "score")
public class ScoreEntity {
    private String descricao;
    @Id
    @Column(name="inicial")
    private Integer scoreInicial;
    @Column(name="final")
    private Integer scoreFinal;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getScoreInicial() {
        return scoreInicial;
    }

    public void setScoreInicial(Integer scoreInicial) {
        this.scoreInicial = scoreInicial;
    }

    public Integer getScoreFinal() {
        return scoreFinal;
    }

    public void setScoreFinal(Integer scoreFinal) {
        this.scoreFinal = scoreFinal;
    }

}
