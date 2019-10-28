package br.com.selecao.candidato.repository;

import br.com.selecao.candidato.entity.Conhecimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ConhecimentoRepository extends JpaRepository<Conhecimento, Long> {

    @Query(value="SELECT * FROM conhecimento WHERE conhecimento.candidato =:idCandidato", nativeQuery = true)
    List<Conhecimento> buscarConhecimentosDoCandidato(@Param("idCandidato")Long id);
}
