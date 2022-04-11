package quixada.npi.springproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import quixada.npi.springproject.model.Matricula;
import quixada.npi.springproject.service.MatriculaService;

@RestController
@RequestMapping("/matricula")
public class MatriculaController {

	@Autowired
	private MatriculaService matriculaService;

	@GetMapping("")
	public List<Matricula> findAll() {
		return matriculaService.findAll();
	}

	@PostMapping("")
	    public Matricula save(@RequestBody Matricula matricula) {
	       // Cadastrar curso e retornar curso cadastrado...
	      return matriculaService.save(matricula);
	}

}
