package br.com.selecao.candidato.bo.interfaces;

import br.com.selecao.candidato.entity.Candidato;

import java.util.List;
import java.util.Optional;

public interface ICandidatoBO {

	List<Candidato> buscarTodosOsCandidatos();

	Optional<Candidato> buscarCandidato(Long idCandidato);

	Candidato salvarCandidato(Candidato candidato);

	void removerCandidato(Long idCandidato);
}
