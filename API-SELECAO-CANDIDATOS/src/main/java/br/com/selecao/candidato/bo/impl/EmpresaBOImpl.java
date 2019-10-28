package br.com.selecao.candidato.bo.impl;

import br.com.selecao.candidato.bo.interfaces.IEmpresaBO;
import br.com.selecao.candidato.entity.Candidato;
import br.com.selecao.candidato.entity.Empresa;
import br.com.selecao.candidato.repository.CandidatoRepository;
import br.com.selecao.candidato.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmpresaBOImpl implements IEmpresaBO {

	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private CandidatoRepository candidatoRepository;

	@Override
	public List<Empresa> buscarTodasAsEmpresas() {
		return empresaRepository.buscarTodasEmpresasAtivas();
	}

	@Override
	public Optional<Empresa> buscarEmpresa(Long idEmpresa) {
		return empresaRepository.buscarEmpresaAtiva(idEmpresa);
	}

	@Override
	public Empresa salvarEmpresa(Empresa empresa) {
		return empresaRepository.save(empresa);
	}

	@Override
	public void removerEmpresa(Long idEmpresa) throws Exception {
		 Optional<Empresa> empresaOpt = empresaRepository.buscarEmpresaAtiva(idEmpresa);
		 if(empresaOpt.isPresent()) {
			 List<Candidato> listCandidato = candidatoRepository.listCandidatoPorEmpresa(idEmpresa);
			 if(listCandidato == null || listCandidato.isEmpty()) {
				 empresaOpt.get().setStatus("DELETADO");
				 empresaRepository.save(empresaOpt.get());
			 }
			 else {
				 throw new Exception();
			 }
		 }
	}
}
