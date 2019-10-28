package br.com.selecao.candidato.bo.impl;

import br.com.selecao.candidato.bo.interfaces.ICandidatoBO;
import br.com.selecao.candidato.dto.CandidatoDTO;
import br.com.selecao.candidato.entity.Candidato;
import br.com.selecao.candidato.repository.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Component
public class CandidatoBOImpl implements ICandidatoBO {

	@Autowired
	private CandidatoRepository candidatoRepository;	

	@Override
	public List<Candidato> buscarTodosCandidatosPorEmpresa(Long idEmpresa) {
		return candidatoRepository.listCandidatoPorEmpresa(idEmpresa);
	}


	@Override
	public void removerCandidato(Long idCandidato) {
		Optional<Candidato> candidatoOpt = candidatoRepository.findById(idCandidato);
		if(candidatoOpt.isPresent()) {
			Candidato candidato = candidatoOpt.get();
			candidato.setStatus("DELETADO");
			candidatoRepository.save(candidato);
		}
		
		
	}


	@Override
	public List<Candidato> buscarTodosCandidatos() {
		return candidatoRepository.buscarTodosCandidatosAtivos();
	}


	@Override
	public Optional<Candidato> buscarCandidato(Long idCandidato) {
		return candidatoRepository.buscarCandidatoAtivo(idCandidato);
	}


	@Override
	public Candidato salvarCandidato(Candidato candidato) {		
		return candidatoRepository.save(candidato);
	}


	@Override
	public List<CandidatoDTO> buscarTodosCandidatosDTO() {
		return null;
	}


	@Override
	public Optional<CandidatoDTO> buscarCandidatoDTO(Long id) {
		return null;
	}

	
}
