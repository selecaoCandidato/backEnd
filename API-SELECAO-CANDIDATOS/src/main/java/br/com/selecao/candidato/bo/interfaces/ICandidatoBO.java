package br.com.selecao.candidato.bo.interfaces;

import java.util.List;
import java.util.Optional;

import br.com.selecao.candidato.entity.Candidato;

public interface ICandidatoBO {
	List<Candidato> buscarTodosCandidatos();

	Optional<Candidato> buscarCandidato(Long idCandidato);

	Candidato salvarCandidato(Candidato candidato);

	void removerCandidato(Long idCandidato);
}
