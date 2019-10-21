package br.com.selecao.candidato.repository;

import br.com.selecao.candidato.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}
