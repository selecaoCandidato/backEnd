package br.com.selecao.candidato.dto;

import com.google.gson.annotations.Expose;

import br.com.selecao.candidato.entity.Empresa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

public class EmpresaDTO implements Serializable {

    private Long id;

    private String nome;

    private String estado;

    private String cidade;
    

	public EmpresaDTO(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public EmpresaDTO(Empresa empresa) {
		this.id = empresa.getId();
		this.cidade = empresa.getCidade();
		this.estado = empresa.getEstado();
		this.nome = empresa.getNome();
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
