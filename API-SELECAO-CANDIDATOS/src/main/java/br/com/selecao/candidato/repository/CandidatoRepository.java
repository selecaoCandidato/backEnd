package br.com.selecao.candidato.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.selecao.candidato.entity.Candidato;

public interface CandidatoRepository extends JpaRepository<Candidato, Long> {

}
