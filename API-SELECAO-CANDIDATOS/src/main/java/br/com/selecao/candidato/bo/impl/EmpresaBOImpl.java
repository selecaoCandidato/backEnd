package br.com.selecao.candidato.bo.impl;

import br.com.selecao.candidato.bo.interfaces.IEmpresaBO;
import br.com.selecao.candidato.entity.Empresa;
import br.com.selecao.candidato.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmpresaBOImpl implements IEmpresaBO {

	@Autowired
	private EmpresaRepository empresaRepository;

	@Override
	public List<Empresa> buscarTodasAsEmpresas() {
		return empresaRepository.findAll();
	}

	@Override
	public Optional<Empresa> buscarEmpresa(Long idEmpresa) {
		return empresaRepository.findById(idEmpresa);
	}

	@Override
	public Empresa salvarEmpresa(Empresa empresa) {
		System.out.println(empresa.getNome());
		return empresaRepository.save(empresa);
	}

	@Override
	public void removerEmpresa(Long idEmpresa) {
		empresaRepository.deleteById(idEmpresa);
	}
}
