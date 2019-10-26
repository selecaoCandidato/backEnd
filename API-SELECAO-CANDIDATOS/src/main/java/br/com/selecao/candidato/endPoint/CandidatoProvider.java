package br.com.selecao.candidato.endPoint;

import br.com.selecao.candidato.bo.interfaces.ICandidatoBO;
import br.com.selecao.candidato.entity.Candidato;
import br.com.selecao.candidato.utils.GsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class CandidatoProvider {

	@Autowired
	private ICandidatoBO candidatoBO;

	@RequestMapping(value = "/candidato", method = RequestMethod.GET)
	public ResponseEntity<Object> buscarTodasAsCandidatos(){

		List<Candidato> candidatos = candidatoBO.buscarTodosOsCandidatos();

		return new ResponseEntity<>(new GsonResponse().toJson(candidatos), HttpStatus.OK);
	}

	@RequestMapping(value = "/candidato/{idCandidato}", method = RequestMethod.GET)
	public ResponseEntity<Object> buscarCandidato(@PathVariable("idCandidato") Long idCandidato){

		Optional<Candidato> candidato = candidatoBO.buscarCandidato(idCandidato);

		return new ResponseEntity<>(new GsonResponse().toJson(candidato.get()), HttpStatus.OK);
	}

	@RequestMapping(value = "/candidato", method = RequestMethod.POST)
	public ResponseEntity<Object> salvarCandidato(@RequestBody Candidato candidato){

		candidato = candidatoBO.salvarCandidato(candidato);

		return new ResponseEntity<>(new GsonResponse().toJson(candidato), HttpStatus.OK);
	}

	@RequestMapping(value = "/candidato", method = RequestMethod.PUT)
	public ResponseEntity<Object> editarCandidato(@RequestBody Candidato candidato){

		candidato = candidatoBO.salvarCandidato(candidato);

		return new ResponseEntity<>(new GsonResponse().toJson(candidato), HttpStatus.OK);
	}

	@RequestMapping(value = "/candidato/{idCandidato}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> removerCandidato(@PathVariable("idCandidato") Long idCandidato){

		candidatoBO.removerCandidato(idCandidato);

		return new ResponseEntity<>(HttpStatus.OK);
	}

}
