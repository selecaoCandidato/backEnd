package br.com.selecao.candidato.endPoint;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.selecao.candidato.bo.interfaces.ICandidatoBO;
import br.com.selecao.candidato.bo.interfaces.IConhecimentoBO;
import br.com.selecao.candidato.entity.Candidato;
import br.com.selecao.candidato.entity.Conhecimento;
import br.com.selecao.candidato.utils.GsonResponse;

@RestController
@CrossOrigin
public class CandidatoProvider {
	@Autowired
	private ICandidatoBO candidatoBO;

	@Autowired
	private IConhecimentoBO conhecimentoBO;

	@RequestMapping(value = "/candidato", method = RequestMethod.GET)
	public ResponseEntity<Object> buscarTodosCandidatos() {

		List<Candidato> candidato = candidatoBO.buscarTodosCandidatos();

		return new ResponseEntity<>(new GsonResponse().toJson(candidato), HttpStatus.OK);

	}

	@RequestMapping(value = "/candidato/{idCandidato}", method = RequestMethod.GET)
	public ResponseEntity<Object> buscarCandidato(@PathVariable("idCandidato") Long idCandidato) {

		Optional<Candidato> candidato = candidatoBO.buscarCandidato(idCandidato);

		Candidato c = candidato.get();
		if (c != null) {
			if (c.getConhecimentos() != null && !c.getConhecimentos().isEmpty()) {
				System.out.println("Conhecimentos (" + c.getNome() + ")");
				for (Conhecimento co : c.getConhecimentos()) {
					System.out.println(co.getNome());
				}
			}
		}

		return new ResponseEntity<>(new GsonResponse().toJson(candidato), HttpStatus.OK);

	}

	@RequestMapping(value = "/candidato", method = RequestMethod.POST)
	public ResponseEntity<Object> salvarCandidato(@RequestBody Candidato candidato) {

		System.out.println("Candidato (" + candidato.getNome() + ")");
		if (candidato.getConhecimentos() != null && !candidato.getConhecimentos().isEmpty()) {
			for (Conhecimento co : candidato.getConhecimentos()) {
				System.out.println(co.getNome());
				co = conhecimentoBO.salvarConhecimento(co);
			}
		}

		candidato = candidatoBO.salvarCandidato(candidato);

		return new ResponseEntity<>(new GsonResponse().toJson(candidato), HttpStatus.OK);
	}

	@RequestMapping(value = "/candidato", method = RequestMethod.PUT)
	public ResponseEntity<Object> editarCandidato(@RequestBody Candidato candidato) {

		System.out.println("Candidato (" + candidato.getNome() + ")");
		if (candidato.getConhecimentos() != null && !candidato.getConhecimentos().isEmpty()) {
			for (Conhecimento co : candidato.getConhecimentos()) {
				System.out.println(co.getNome());
				co = conhecimentoBO.salvarConhecimento(co);
			}
		}
		candidato = candidatoBO.salvarCandidato(candidato);

		return new ResponseEntity<>(new GsonResponse().toJson(candidato), HttpStatus.OK);

	}

	@RequestMapping(value = "/candidato/{idCandidato}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> removerCandidato(@PathVariable("idCandidato") Long idCandidato) {

		candidatoBO.removerCandidato(idCandidato);

		return new ResponseEntity<>(HttpStatus.OK);

	}

}
