package br.com.selecao.candidato.entity;

import javax.persistence.*;

@Entity
public class Conhecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdConhecimento")
    private Long id;

    @Column
    private String conhecimento;

    @Column
    private String nivel;

    //@ManyToOne
    //@JoinColumn(name = "id_candidato")
    private Long candidato;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConhecimento() {
        return conhecimento;
    }

    public void setConhecimento(String conhecimento) {
        this.conhecimento = conhecimento;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public Long getCandidato() {
        return candidato;
    }

    public void setCandidato(Long candidato) {
        this.candidato = candidato;
    }
}
