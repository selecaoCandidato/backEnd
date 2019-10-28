package br.com.selecao.candidato.bo.interfaces;

import br.com.selecao.candidato.dto.ConhecimentoDTO;
import br.com.selecao.candidato.entity.Conhecimento;

import java.util.List;
import java.util.Optional;

public interface IConhecimentoBO {

	List<Conhecimento> buscarTodosConhecimentos();
	
	List<Conhecimento> buscarTodosConhecimentosPorCandidato(Long idCandidato);
	
	List<ConhecimentoDTO> buscarTodosConhecimentosDTOPorCandidato(Long idCandidato);
	

	void removerTodosConhecimentoPorIdCandidato(Long idCandidato);

	Optional<Conhecimento> buscarConhecimento(Long idConhecimento);

	Conhecimento salvarConhecimento(Conhecimento conhecimento);

	void removerConhecimento(Long idConhecimento);
}
