package br.com.selecao.candidato.endPoint;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.selecao.candidato.bo.interfaces.IConhecimentoBO;
import br.com.selecao.candidato.bo.interfaces.IConhecimentoBO;
import br.com.selecao.candidato.entity.Conhecimento;
import br.com.selecao.candidato.utils.GsonResponse;

@RestController
@CrossOrigin
@RequestMapping("/conhecimento")
public class ConhecimentoProvider {

	@Autowired
	private IConhecimentoBO conhecimentoBO;

	@GetMapping()
	public ResponseEntity<Object> buscarTodasAsConhecimentos(){

		List<Conhecimento> conhecimentos = conhecimentoBO.buscarTodosConhecimentos();

		return ResponseEntity.status(HttpStatus.OK).body(new GsonResponse().toJson(conhecimentos));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> buscarConhecimento(@PathVariable Long id){

		List<Conhecimento> conhecimentos = conhecimentoBO.buscarTodosConhecimentosPorCandidato(id);

		return ResponseEntity.status(HttpStatus.OK).body(new GsonResponse().toJson(conhecimentos));
	}

	/*
	 * @PostMapping public ResponseEntity<Object> salvarConhecimento(@RequestBody
	 * Conhecimento conhecimento){
	 * 
	 * conhecimento = conhecimentoBO.salvarConhecimento(conhecimento);
	 * 
	 * return ResponseEntity.status(HttpStatus.CREATED).body(conhecimento); }
	 * 
	 * @PutMapping() public ResponseEntity<Object> editarConhecimento(@RequestBody
	 * Conhecimento conhecimento){
	 * 
	 * conhecimento = conhecimentoBO.salvarConhecimento(conhecimento);
	 * 
	 * return ResponseEntity.status(HttpStatus.OK).body(conhecimento); }
	 * 
	 * @DeleteMapping("/id") public ResponseEntity<Object>
	 * removerConhecimento(@PathVariable Long id){
	 * 
	 * conhecimentoBO.removerConhecimento(id);
	 * 
	 * return ResponseEntity.status(HttpStatus.OK).build(); }
	 */

}
