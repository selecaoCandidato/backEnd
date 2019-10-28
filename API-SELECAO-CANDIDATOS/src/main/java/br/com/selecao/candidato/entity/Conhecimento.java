package br.com.selecao.candidato.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.SQLDelete;

import br.com.selecao.candidato.dto.ConhecimentoDTO;
import br.com.selecao.candidato.enums.Sexo;

@Entity
public class Conhecimento {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conhecimento")
    private Long id;

    @NotNull(message = "Insira a descriçao")
    @Column
    private String descricao;

    @NotNull(message = "Insira o nivel")
    private String nivel;
    
    @ManyToOne
    @JoinColumn(name = "id_candidato")
    private Candidato candidato;
    
    @NotNull
    @Column
    private String status;
    
    

	public Conhecimento() {
		this.status = "ATIVO";
	}
	
	public void setConhecimento(ConhecimentoDTO conhecimentoDTO) {
		this.id = conhecimentoDTO.getId();
		this.descricao = conhecimentoDTO.getDescricao();
		this.nivel = conhecimentoDTO.getNivel();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
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
		Conhecimento other = (Conhecimento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
    
}
