package br.com.selecao.candidato.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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

    @ManyToOne
    @JoinColumn(name = "IdCandidato", nullable = false)
    private Candidato candidato;
}
