package br.com.selecao.candidato.dto;

import br.com.selecao.candidato.entity.Conhecimento;

public class ConhecimentoDTO {
	
	
    private Long id;

    private String descricao;

    private String nivel;
    
    private Long idCandidato;
    
    

	public ConhecimentoDTO() {
	}

	public ConhecimentoDTO(Long id, String descricao, String nivel, Long idCandidato) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.nivel = nivel;
		this.idCandidato = idCandidato;
	}

	public ConhecimentoDTO(Conhecimento conhecimento) {
		this.id = conhecimento.getId();
		this.descricao = conhecimento.getDescricao();
		this.nivel = conhecimento.getNivel();
		this.idCandidato = conhecimento.getCandidato().getId();
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

	public Long getIdCandidato() {
		return idCandidato;
	}

	public void setIdCandidato(Long idCandidato) {
		this.idCandidato = idCandidato;
	}
    
}
