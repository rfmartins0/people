package br.com.people.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "afinidade")
public class AffinityEntity {

    @Id
    private String regiao;
    @Column(name="estados")
    @ElementCollection
    @CollectionTable(name = "afinidade_estados", joinColumns = @JoinColumn(name = "regiao"))
    private Set<String> estados = new HashSet<>();

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
