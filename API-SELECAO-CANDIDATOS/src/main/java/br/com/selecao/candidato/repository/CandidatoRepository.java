package br.com.selecao.candidato.repository;

import br.com.selecao.candidato.entity.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatoRepository extends JpaRepository<Candidato, Long> {

}
