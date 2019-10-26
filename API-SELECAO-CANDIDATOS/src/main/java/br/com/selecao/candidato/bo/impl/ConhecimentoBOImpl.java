package br.com.selecao.candidato.bo.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.selecao.candidato.bo.interfaces.IConhecimentoBO;
import br.com.selecao.candidato.entity.Conhecimento;
import br.com.selecao.candidato.repository.ConhecimentoRepository;
@Component
public class ConhecimentoBOImpl implements IConhecimentoBO {
	@Autowired
	private ConhecimentoRepository conhecimentoRepository;

	@Override
	public List<Conhecimento> buscarTodosConhecimentos() {
		
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

}
