package br.com.selecao.candidato.repository;

import br.com.selecao.candidato.dto.ConhecimentoDTO;
import br.com.selecao.candidato.entity.Candidato;
import br.com.selecao.candidato.entity.Conhecimento;
import br.com.selecao.candidato.entity.Empresa;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ConhecimentoRepository extends JpaRepository<Conhecimento, Long> {

	@Query(value = "Select c from Conhecimento c "
			+ "join c.candidato can "
			+ " where can.id = :idCandidato")
	List<Conhecimento> listConhecimentoPorCandidato(@Param("idCandidato") Long id);
	
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE Conhecimento co "
			+ " SET co.status = 'DELETADO' "
			+ " where co.status = 'ATIVO' "
			+ " and co.candidato.id = :id")
	void mudarStatusParaDeletado(@Param("id") Long id);
	
	/*
	 * @Query(value = "Select new br.com.selecao.candidato.dto.ConhecimentoDTO(" +
	 * "co.id, co.descricao, co.nivel, can.id" + " ) from Conhecimento c " +
	 * "join c.candidato can " + " where can.id = :idCandidato")
	 * List<ConhecimentoDTO> listConhecimentoDTOPorCandidato(@Param("idCandidato")
	 * Long id);
	 */
	
	/*
	 * @Query(value = "UPDATE Conhencimento co " + " JOIN " +
	 * " SET co.status = 'DELETADO' " + " where c.status = 'ATIVO' " +
	 * " and c.id = :id") void mudarStatusParaDeletado(@Param("id") Long id);
	 */
}
