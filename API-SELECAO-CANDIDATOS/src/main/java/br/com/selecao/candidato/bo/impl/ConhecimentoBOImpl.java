package br.com.selecao.candidato.bo.impl;

import br.com.selecao.candidato.bo.interfaces.ICandidatoBO;
import br.com.selecao.candidato.bo.interfaces.IConhecimentoBO;
import br.com.selecao.candidato.entity.Candidato;
import br.com.selecao.candidato.entity.Conhecimento;
import br.com.selecao.candidato.repository.CandidatoRepository;
import br.com.selecao.candidato.repository.ConhecimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ConhecimentoBOImpl implements IConhecimentoBO {

	@Autowired
	private CandidatoRepository candidatoRepository;

	@Autowired
	ConhecimentoRepository conhecimentoRepository;

	@Override
	public List<Conhecimento> buscarTodosOsConhecimentos() {
		return conhecimentoRepository.findAll();
	}

	@Override
	public Optional<Conhecimento> buscarConhecimento(Long idConhecimento) {
		return conhecimentoRepository.findById(idConhecimento);
	}

	@Override
	public Conhecimento salvarConhecimento(Conhecimento conhecimento) {
		return conhecimentoRepository.save(conhecimento);
	}

	@Override
	public void removerConhecimento(Long idConhecimento) {
		conhecimentoRepository.deleteById(idConhecimento);
	}

	@Override
	public List<Conhecimento> buscarConhecimentosDoCandidato(Long idCandidato) {
		return conhecimentoRepository.buscarConhecimentosDoCandidato(idCandidato);
	}
}
