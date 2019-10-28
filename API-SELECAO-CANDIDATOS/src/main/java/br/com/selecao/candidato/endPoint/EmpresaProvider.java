package br.com.selecao.candidato.endPoint;

import br.com.selecao.candidato.bo.interfaces.IEmpresaBO;
import br.com.selecao.candidato.dto.EmpresaDTO;
import br.com.selecao.candidato.entity.Empresa;
import br.com.selecao.candidato.utils.GsonResponse;
import com.google.gson.Gson;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/empresa")
public class EmpresaProvider {

	@Autowired
	private IEmpresaBO empresaBO;

	@GetMapping
	public ResponseEntity<Object> buscarTodasAsEmpresas(){

		List<Empresa> empresas = empresaBO.buscarTodasAsEmpresas();
		
		List<EmpresaDTO> empresasDTO = new ArrayList<>();
		for(Empresa empresa : empresas) {
			empresasDTO.add(new EmpresaDTO(empresa));
		}

		return ResponseEntity.status(HttpStatus.OK).body(new GsonResponse().toJson(empresasDTO));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> buscarEmpresa(@PathVariable("id") Long idEmpresa){

		Optional<Empresa> empresa = empresaBO.buscarEmpresa(idEmpresa);
		
		if(empresa.isPresent()) {
			EmpresaDTO empresaDTO = new EmpresaDTO(empresa.get());
			return ResponseEntity.status(HttpStatus.OK).body(new GsonResponse().toJson(empresaDTO));
		}

		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<Object> salvarEmpresa(@RequestBody EmpresaDTO empresaDTO){

		Empresa empresa = new Empresa();
		
		empresa.setEmpresaDTO(empresaDTO);
		
		empresa = empresaBO.salvarEmpresa(empresa);

		return ResponseEntity.status(HttpStatus.CREATED).body(new GsonResponse().toJson(empresaDTO));
	}

	@PutMapping
	public ResponseEntity<Object> editarEmpresa(@RequestBody EmpresaDTO empresaDTO){

		Empresa empresa = new Empresa();
		
		empresa.setEmpresaDTO(empresaDTO);
		
		empresa = empresaBO.salvarEmpresa(empresa);

		return ResponseEntity.status(HttpStatus.CREATED).body(new GsonResponse().toJson(empresaDTO));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> removerEmpresa(@PathVariable("id") Long idEmpresa){

		try {
			empresaBO.removerEmpresa(idEmpresa);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

		return ResponseEntity.status(HttpStatus.OK).build();
	}

}
