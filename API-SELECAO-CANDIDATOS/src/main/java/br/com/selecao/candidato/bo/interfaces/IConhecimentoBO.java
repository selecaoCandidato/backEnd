package br.com.selecao.candidato.bo.interfaces;

import br.com.selecao.candidato.entity.Conhecimento;

import java.util.List;
import java.util.Optional;

public interface IConhecimentoBO {

	List<Conhecimento> buscarTodosOsConhecimentos();

	Optional<Conhecimento> buscarConhecimento(Long idConhecimento);

	Conhecimento salvarConhecimento(Conhecimento conhecimento);

	void removerConhecimento(Long idConhecimento);

	List<Conhecimento> buscarConhecimentosDoCandidato(Long id);
}
