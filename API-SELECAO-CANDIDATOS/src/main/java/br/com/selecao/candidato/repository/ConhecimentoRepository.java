package br.com.selecao.candidato.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.selecao.candidato.entity.Conhecimento;

public interface ConhecimentoRepository extends JpaRepository<Conhecimento, Long> {

}
