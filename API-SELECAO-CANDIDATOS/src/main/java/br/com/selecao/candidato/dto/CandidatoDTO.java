package br.com.selecao.candidato.dto;

import java.util.List;

import br.com.selecao.candidato.entity.Candidato;

public class CandidatoDTO {
	
    private Long id;

    private String nome;

    private int idade;
    
    private String sexo;
    
    private String telefone;
    
    private Long idEmpresa;
    
    private String empresa;
    
    private String observacao;
    
    private List<ConhecimentoDTO> listConhecimento;
    
    private List<ConhecimentoDTO> listConhecimentoDeletado;    
    

	public CandidatoDTO() {
	}

	public CandidatoDTO(Long id, String nome, int idade, String sexo, String telefone, String empresa) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.sexo = sexo;
		this.telefone = telefone;
		this.empresa = empresa;
	}

	public CandidatoDTO(Long id, String nome, int idade, String sexo, String telefone, Long idempresa,
			String observacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.sexo = sexo;
		this.telefone = telefone;
		this.idEmpresa = idempresa;
		this.observacao = observacao;
	}


	public CandidatoDTO(Candidato candidato) {
		this.id = candidato.getId();
		this.nome = candidato.getNome();
		this.idade = candidato.getIdade();
		this.sexo = candidato.getSexo().name();
		this.telefone = candidato.getTelefone();
		this.idEmpresa = candidato.getEmpresa().getId();
		this.empresa = candidato.getEmpresa().getNome();
		this.observacao = candidato.getObservacao();
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Long getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public List<ConhecimentoDTO> getListConhecimento() {
		return listConhecimento;
	}

	public void setListConhecimento(List<ConhecimentoDTO> listConhecimento) {
		this.listConhecimento = listConhecimento;
	}

	public List<ConhecimentoDTO> getListConhecimentoDeletado() {
		return listConhecimentoDeletado;
	}

	public void setListConhecimentoDeletado(List<ConhecimentoDTO> listConhecimentoDeletado) {
		this.listConhecimentoDeletado = listConhecimentoDeletado;
	} 
    
}
