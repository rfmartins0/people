package br.com.people.dto.response;

import java.util.ArrayList;
import java.util.List;

public class PersonResponse {

    private String nome;
    private String telefone;
    private Short idade;
    private List<String> estados = new ArrayList<>();
    private String scoreDescricao;

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

    public List<String> getEstados() {
        return estados;
    }

    public void setEstados(List<String> estados) {
        this.estados = estados;
    }

    public String getScoreDescricao() {
        return scoreDescricao;
    }

    public void setScoreDescricao(String scoreDescricao) {
        this.scoreDescricao = scoreDescricao;
    }
}
