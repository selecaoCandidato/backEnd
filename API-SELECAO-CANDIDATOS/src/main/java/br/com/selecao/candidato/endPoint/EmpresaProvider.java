package br.com.selecao.candidato.endPoint;

import br.com.selecao.candidato.bo.interfaces.IEmpresaBO;
import br.com.selecao.candidato.entity.Empresa;
import br.com.selecao.candidato.utils.GsonResponse;
import com.google.gson.Gson;
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
public class EmpresaProvider {

	@Autowired
	private IEmpresaBO empresaBO;

	@RequestMapping(value = "/empresa", method = RequestMethod.GET)
	public ResponseEntity<Object> buscarTodasAsEmpresas(){

		List<Empresa> empresas = empresaBO.buscarTodasAsEmpresas();

		return new ResponseEntity<>(new GsonResponse().toJson(empresas), HttpStatus.OK);
	}

	@RequestMapping(value = "/empresa/{idEmpresa}", method = RequestMethod.GET)
	public ResponseEntity<Object> buscarEmpresa(@PathVariable("idEmpresa") Long idEmpresa){

		Optional<Empresa> empresa = empresaBO.buscarEmpresa(idEmpresa);

		return new ResponseEntity<>(new GsonResponse().toJson(empresa.get()), HttpStatus.OK);
	}

	@RequestMapping(value = "/empresa", method = RequestMethod.POST)
	public ResponseEntity<Object> salvarEmpresa(@RequestBody Empresa empresa){

		empresa = empresaBO.salvarEmpresa(empresa);

		return new ResponseEntity<>(new GsonResponse().toJson(empresa), HttpStatus.OK);
	}

	@RequestMapping(value = "/empresa", method = RequestMethod.PUT)
	public ResponseEntity<Object> editarEmpresa(@RequestBody Empresa empresa){

		empresa = empresaBO.salvarEmpresa(empresa);

		return new ResponseEntity<>(new GsonResponse().toJson(empresa), HttpStatus.OK);
	}

	@RequestMapping(value = "/empresa/{idEmpresa}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> removerEmpresa(@PathVariable("idEmpresa") Long idEmpresa){

		empresaBO.removerEmpresa(idEmpresa);

		return new ResponseEntity<>(HttpStatus.OK);
	}

}
