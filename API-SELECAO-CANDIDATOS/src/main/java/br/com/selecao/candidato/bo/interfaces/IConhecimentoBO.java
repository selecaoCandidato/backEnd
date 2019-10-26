package br.com.selecao.candidato.bo.interfaces;

import java.util.List;
import java.util.Optional;

import br.com.selecao.candidato.entity.Conhecimento;

public interface IConhecimentoBO {
	List<Conhecimento> buscarTodosConhecimentos();

	Optional<Conhecimento> buscarConhecimento(Long idConhecimento);

	Conhecimento salvarConhecimento(Conhecimento conhecimento);

	void removerConhecimento(Long idConhecimento);
}
