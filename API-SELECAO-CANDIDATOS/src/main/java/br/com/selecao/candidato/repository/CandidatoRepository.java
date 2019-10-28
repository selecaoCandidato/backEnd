package br.com.selecao.candidato.repository;

import br.com.selecao.candidato.dto.CandidatoDTO;
import br.com.selecao.candidato.entity.Candidato;
import br.com.selecao.candidato.entity.Empresa;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CandidatoRepository extends JpaRepository<Candidato, Long> {

	@Query(value = "Select c from Candidato c " + "join c.empresa e " + " where e.id = :idEmpresa and c.status = 'ATIVO' ")
	List<Candidato> listCandidatoPorEmpresa(@Param("idEmpresa") Long id);

	/*
	 * @Query(value = "Select new br.com.selecao.candidato.dto.CandidatoDTO(" +
	 * "c.id, c.nome, c.idade, c.sexo, c.telefone, e.nome" + ")" +
	 * " from Candidato c " + "join c.empresa e " + " where c.status = 'ATIVO' ")
	 * List<CandidatoDTO> buscarTodosCandidatosDTO();
	 * 
	 * @Query(value = "Select new br.com.selecao.candidato.dto.CandidatoDTO(" +
	 * "c.id, c.nome, c.idade, c.sexo, c.telefone, e.id, c.observacao " + ")" +
	 * " from Candidato c " + "join c.empresa e " + " where c.status = 'ATIVO' " +
	 * " and c.id = :id") Optional<CandidatoDTO> buscarCandidatoDTO(@Param("id")
	 * Long id);
	 */

	@Query(value = "Select c " + " from Candidato c " + "join c.empresa e " + " where c.status = 'ATIVO' ")
	List<Candidato> buscarTodosCandidatosAtivos();

	@Query(value = "Select c " + " from Candidato c "
			+ "join c.empresa e " + " where c.status = 'ATIVO' " + " and c.id = :id")
	Optional<Candidato> buscarCandidatoAtivo(@Param("id") Long id);

	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE Candidato c" 
			+ " SET c.status = 'DELETADO' "
			+ " where c.status = 'ATIVO' "
			+ " and c.id = :id")
	void mudarStatusCandidatoParaDeletado(@Param("id") Long id);
}
