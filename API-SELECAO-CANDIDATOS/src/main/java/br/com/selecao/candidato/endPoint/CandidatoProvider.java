package br.com.selecao.candidato.endPoint;

import java.util.ArrayList;
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

import br.com.selecao.candidato.bo.interfaces.ICandidatoBO;
import br.com.selecao.candidato.bo.interfaces.IConhecimentoBO;
import br.com.selecao.candidato.bo.interfaces.IEmpresaBO;
import br.com.selecao.candidato.dto.CandidatoDTO;
import br.com.selecao.candidato.dto.ConhecimentoDTO;
import br.com.selecao.candidato.bo.interfaces.ICandidatoBO;
import br.com.selecao.candidato.entity.Candidato;
import br.com.selecao.candidato.entity.Conhecimento;
import br.com.selecao.candidato.enums.Sexo;
import br.com.selecao.candidato.exceptions.PdfDocumentBuilderException;
import br.com.selecao.candidato.utils.GsonResponse;

@RestController
@CrossOrigin
@RequestMapping("/candidato")
public class CandidatoProvider {

	@Autowired
	private ICandidatoBO candidatoBO;

	@Autowired
	private IConhecimentoBO conhecimentoBO;
	
	@Autowired
	private IEmpresaBO empresaBO;

	@GetMapping
	public ResponseEntity<Object> buscarTodosCandidatos() {

		List<Candidato> listCandidato = candidatoBO.buscarTodosCandidatos();
		List<CandidatoDTO> listCandidatoDTO = new ArrayList<>();
		
		for(Candidato candidato : listCandidato) {
			listCandidatoDTO.add(new CandidatoDTO(candidato));
		}

		return ResponseEntity.status(HttpStatus.OK).body(new GsonResponse().toJson(listCandidatoDTO));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> buscarCandidato(@PathVariable Long id) {

		Optional<Candidato> candidato = candidatoBO.buscarCandidato(id);

		if (candidato.isPresent()) {
			CandidatoDTO candidatoDTO = new CandidatoDTO(candidato.get());
			candidatoDTO.setListConhecimento(new ArrayList<ConhecimentoDTO>());
			List<Conhecimento> listConhecimento = conhecimentoBO.buscarTodosConhecimentos();
			for(Conhecimento conhecimento : listConhecimento) {
				ConhecimentoDTO conhecimentoDTO = new ConhecimentoDTO(conhecimento);
				candidatoDTO.getListConhecimento().add(conhecimentoDTO);
				
			}
			return ResponseEntity.status(HttpStatus.OK).body(new GsonResponse().toJson(candidatoDTO));
		}

		return ResponseEntity.notFound().build();

	}

	@PostMapping
	public ResponseEntity<Object> salvarCandidato(@RequestBody CandidatoDTO candidatoDTO) {

		Candidato candidato = new Candidato();
		candidato.setCandidato(candidatoDTO);
		candidato.setEmpresa((empresaBO.buscarEmpresa(candidatoDTO.getIdEmpresa())).get());
		
		candidato = candidatoBO.salvarCandidato(candidato);

		if (candidatoDTO.getListConhecimento() != null) {
			for (ConhecimentoDTO conhecimentoDTO : candidatoDTO.getListConhecimento()) {
				Conhecimento conhecimento = new Conhecimento();
				conhecimento.setConhecimento(conhecimentoDTO);
				conhecimento.setCandidato(candidato);
				conhecimentoBO.salvarConhecimento(conhecimento);
			}
		}
		
		if (candidatoDTO.getListConhecimentoDeletado() != null) {
			for (ConhecimentoDTO conhecimentoDTO : candidatoDTO.getListConhecimentoDeletado()) {
				if(conhecimentoDTO.getId() != null) {
					conhecimentoBO.removerConhecimento(conhecimentoDTO.getId());
				}
				
			}
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(new GsonResponse().toJson(candidatoDTO));
	}

	@PutMapping()
	public ResponseEntity<Object> editarCandidato(@RequestBody CandidatoDTO candidatoDTO) {
		
		Candidato candidato = new Candidato();
		candidato.setCandidato(candidatoDTO);
		candidato.setEmpresa((empresaBO.buscarEmpresa(candidatoDTO.getIdEmpresa())).get());
		
		candidato = candidatoBO.salvarCandidato(candidato);

		if (candidatoDTO.getListConhecimento() != null) {
			for (ConhecimentoDTO conhecimentoDTO : candidatoDTO.getListConhecimento()) {
				Conhecimento conhecimento = new Conhecimento();
				conhecimento.setConhecimento(conhecimentoDTO);
				conhecimento.setCandidato(candidato);
				conhecimentoBO.salvarConhecimento(conhecimento);
			}
		}
		
		if (candidatoDTO.getListConhecimentoDeletado() != null) {
			for (ConhecimentoDTO conhecimentoDTO : candidatoDTO.getListConhecimentoDeletado()) {
				if(conhecimentoDTO.getId() != null) {
					conhecimentoBO.removerConhecimento(conhecimentoDTO.getId());
				}
				
			}
		}

		return ResponseEntity.status(HttpStatus.OK).body(new GsonResponse().toJson(candidatoDTO));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> removerCandidato(@PathVariable Long id) {

		candidatoBO.removerCandidato(id);
		
		List<Conhecimento> listConhecimento = conhecimentoBO.buscarTodosConhecimentosPorCandidato(id);
		
		for(Conhecimento conhecimento : listConhecimento) {
			conhecimentoBO.removerConhecimento(conhecimento.getId());
		}
		

		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@GetMapping("/genero")
	public ResponseEntity<Object> listarGenero() {

		List<String> listaGenero = new ArrayList<>();
		
		for(Sexo sexo : Sexo.values()) {
			listaGenero.add(sexo.name());
		}

		return ResponseEntity.ok().body(new GsonResponse().toJson(listaGenero));

	}

}
