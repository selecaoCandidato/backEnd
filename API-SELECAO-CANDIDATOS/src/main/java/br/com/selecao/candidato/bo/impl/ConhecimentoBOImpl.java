package br.com.selecao.candidato.bo.impl;

import br.com.selecao.candidato.bo.interfaces.IConhecimentoBO;
import br.com.selecao.candidato.dto.ConhecimentoDTO;
import br.com.selecao.candidato.entity.Conhecimento;
import br.com.selecao.candidato.repository.ConhecimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Component
public class ConhecimentoBOImpl implements IConhecimentoBO {

	@Autowired
	private ConhecimentoRepository conhecimentoRepository;
	
	@Override
	public List<Conhecimento> buscarTodosConhecimentos() {
		return conhecimentoRepository.findAll();
	}

	@Override
	public List<Conhecimento> buscarTodosConhecimentosPorCandidato(Long idCandidato) {
		return conhecimentoRepository.listConhecimentoPorCandidato(idCandidato);
	}	

	@Override
	public Optional<Conhecimento> buscarConhecimento(Long idConhecimento) {
		return conhecimentoRepository.findById(idConhecimento);
	}

	@Override
	public Conhecimento salvarConhecimento(Conhecimento candidato) {
		return conhecimentoRepository.save(candidato);
	}

	@Override
	public void removerConhecimento(Long idConhecimento) {
		Optional<Conhecimento> conhecimentoOpt = conhecimentoRepository.findById(idConhecimento);
		if(conhecimentoOpt.isPresent()) {
			Conhecimento conhecimento = conhecimentoOpt.get();
			conhecimento.setStatus("DELETADO");
			conhecimentoRepository.save(conhecimento);
		}
		
	}

	@Override
	public List<ConhecimentoDTO> buscarTodosConhecimentosDTOPorCandidato(Long idCandidato) {
		return null;
	}

	@Override
	public void removerTodosConhecimentoPorIdCandidato(Long idCandidato) {
		conhecimentoRepository.mudarStatusParaDeletado(idCandidato);
		
	}


	
}
