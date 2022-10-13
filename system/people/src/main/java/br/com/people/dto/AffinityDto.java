package br.com.people.dto;

import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

public class AffinityDto {

    @NotBlank(message = "A região é campo obrigatório")
    private String regiao;
    private Set<String> estados = new HashSet<String>();

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public Set<String> getEstados() {
        return estados;
    }

    public void setEstados(Set<String> estados) {
        this.estados = estados;
    }

}
