package br.com.selecao.candidato.repository;

import br.com.selecao.candidato.entity.Empresa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

	@Query(value = "Select e " + " from Empresa e " + " where e.status = 'ATIVO' ")
	List<Empresa> buscarTodasEmpresasAtivas();

	@Query(value = "Select e " + " from Empresa e " + " where e.status = 'ATIVO' " 
	+ " and e.id = :id")
	Optional<Empresa> buscarEmpresaAtiva(@Param("id") Long id);
}
