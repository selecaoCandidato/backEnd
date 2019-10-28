package br.com.selecao.candidato.entity;

import com.google.gson.annotations.Expose;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Empresa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdEmpresa")
    private Long id;

    @Column
    private String nome;

    @Column
    private String estado;

    @Column
    private String cidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
