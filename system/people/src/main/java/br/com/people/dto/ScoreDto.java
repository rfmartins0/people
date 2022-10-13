package br.com.people.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

public class ScoreDto {

    @NotBlank(message = "A descrição é campo obrigatório")
    private String scoreDescricao;
    @PositiveOrZero(message= "O score inicial deve ser um número positivo ou zero")
    private Integer scoreInicial;
    @PositiveOrZero(message= "O score final deve ser um número positivo ou zero")
    private Integer scoreFinal;

    public String getScoreDescricao() {
        return scoreDescricao;
    }

    public void setScoreDescricao(String scoreDescricao) {
        this.scoreDescricao = scoreDescricao;
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
