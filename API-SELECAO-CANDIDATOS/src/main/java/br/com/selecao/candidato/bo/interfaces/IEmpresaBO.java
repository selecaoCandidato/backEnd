package br.com.selecao.candidato.bo.interfaces;

import br.com.selecao.candidato.entity.Empresa;

import java.util.List;
import java.util.Optional;

public interface IEmpresaBO {

	List<Empresa> buscarTodasAsEmpresas();

	Optional<Empresa> buscarEmpresa(Long idEmpresa);

	Empresa salvarEmpresa(Empresa empresa);

	void removerEmpresa(Long idEmpresa);
}
