package br.com.selecao.candidato.bo.interfaces;

import br.com.selecao.candidato.dto.CandidatoDTO;
import br.com.selecao.candidato.entity.Candidato;
import br.com.selecao.candidato.exceptions.PdfDocumentBuilderException;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ICandidatoBO {

	List<Candidato> buscarTodosCandidatos();
	
	List<Candidato> buscarTodosCandidatosPorEmpresa(Long idEmpresa);

	Optional<Candidato> buscarCandidato(Long idCandidato);

	void removerCandidato(Long idCandidato);

	List<CandidatoDTO> buscarTodosCandidatosDTO();

	Optional<CandidatoDTO> buscarCandidatoDTO(Long id);

	Candidato salvarCandidato(Candidato candidato);
}
