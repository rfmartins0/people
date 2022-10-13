package br.com.people.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.PositiveOrZero;

public class PersonDto {

    @Size(min = 2, max = 200, message
            = "O nome deve conter entre 2 e 200 caracteres")
    private String nome;
    @NotBlank(message = "O telefone é campo obrigatório")
    @Pattern(regexp="^(0|[1-9][0-9]*)$", message= "O número de telefone deve conter somente números")
    private String telefone;
    @PositiveOrZero(message= "A idade deve ser um número positivo ou zero")
    private Short idade;
    @NotBlank(message = "A cidade é campo obrigatório")
    private String cidade;
    @NotBlank(message = "O estado é campo obrigatório")
    private String estado;
    @PositiveOrZero(message= "O score deve ser um número positivo ou zero")
    private Integer score;
    @NotBlank(message = "A região é campo obrigatório")
    private String regiao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Short getIdade() {
        return idade;
    }

    public void setIdade(Short idade) {
        this.idade = idade;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

}
