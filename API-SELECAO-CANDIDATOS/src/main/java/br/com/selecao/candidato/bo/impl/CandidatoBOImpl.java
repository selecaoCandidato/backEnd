package br.com.selecao.candidato.bo.impl;

import br.com.selecao.candidato.bo.interfaces.ICandidatoBO;
import br.com.selecao.candidato.entity.Candidato;
import br.com.selecao.candidato.repository.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CandidatoBOImpl implements ICandidatoBO {

	@Autowired
	private CandidatoRepository candidatoRepository;

	@Override
	public List<Candidato> buscarTodosOsCandidatos() {
		return candidatoRepository.findAll();
	}

	@Override
	public Optional<Candidato> buscarCandidato(Long idCandidato) {
		return candidatoRepository.findById(idCandidato);
	}

	@Override
	public Candidato salvarCandidato(Candidato candidato) {
		return candidatoRepository.save(candidato);
	}

	@Override
	public void removerCandidato(Long idCandidato) {
		candidatoRepository.deleteById(idCandidato);
	}
}
