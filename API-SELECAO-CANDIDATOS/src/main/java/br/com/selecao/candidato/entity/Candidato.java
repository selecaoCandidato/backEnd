package br.com.selecao.candidato.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.google.gson.annotations.Expose;

import br.com.selecao.candidato.dto.CandidatoDTO;
import br.com.selecao.candidato.enums.Sexo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.List;

@Entity
public class Candidato implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_candidato")
    private Long id;

    @NotNull(message = "Insira um nome")
    @Column
    private String nome;

    @NotNull(message = "Insira a idade")
    @Column
    private int idade;
    
    @Column
    private Sexo sexo;
    
    @NotNull(message = "Insira o telefone")
    @Length(max = 9, min = 7, message = "Tamanho inválido de telefone")
    @Column
    private String telefone;
    
    @NotNull(message = "Selecione a empresa")
    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;
    
    @Column(columnDefinition = "text")
    private String observacao;
    
    @NotNull
    @Column
    private String status;
    
    
    
    public Candidato() {
    	this.status = "ATIVO";
	}


	public void setCandidato(CandidatoDTO candidatoDTO) {
    	this.id = candidatoDTO.getId();
    	this.nome = candidatoDTO.getNome();
    	this.idade = candidatoDTO.getIdade();
    	this.sexo = Sexo.valueOf(candidatoDTO.getSexo());
    	this.telefone = candidatoDTO.getTelefone();
    	this.observacao = candidatoDTO.getObservacao();
    }
    

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

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Candidato other = (Candidato) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
