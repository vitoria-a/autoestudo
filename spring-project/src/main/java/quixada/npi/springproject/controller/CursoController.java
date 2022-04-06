package quixada.npi.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import quixada.npi.springproject.model.Curso;
import quixada.npi.springproject.service.CursoService;

import java.util.List;


@RestController
@RequestMapping("/cursos")

public class CursoController {
	
	@Autowired
    private CursoService cursoService;

    @GetMapping("")
    public List<Curso> findAll() {
        return cursoService.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<List<Curso>> find(@PathVariable String id) {
        // Busca curso pelo id e retornar curso...
        return ResponseEntity.ok().build();
    }

    @PostMapping("")
    public Curso save(@RequestBody Curso curso) {
       // Cadastrar curso e retornar curso cadastrado...
       return cursoService.save(curso);
    }

    @DeleteMapping("{id}")
    //TODO: excluir curso
    public void deleteCurso(@PathVariable Integer id) {
    	cursoService.deleteCurso(id);
    }
    
    @PutMapping("{id}")
    public Curso update(@RequestBody Curso curso) {
    	return cursoService.save(curso);
    }
    

}
