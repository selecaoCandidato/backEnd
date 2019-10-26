package br.com.selecao.candidato.entity;

import com.google.gson.annotations.Expose;

import br.com.selecao.candidato.utils.GsonExclude;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.io.Serializable;
import java.util.Set;

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
    
    @GsonExclude
    @OneToMany(mappedBy = "empresa")
    private Set<Candidato> candidatos;

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
   
    public Set<Candidato> getCandidato() {
		return candidatos;
	}
	
	public void setcandidatos(Set<Candidato> candidatos) {
		this.candidatos = candidatos;
	}
}
