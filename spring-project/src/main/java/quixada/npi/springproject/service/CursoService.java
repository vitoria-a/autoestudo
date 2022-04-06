package quixada.npi.springproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import quixada.npi.springproject.model.Curso;

@Service
public interface CursoService {

	List<Curso> findAll();

	Curso save(Curso curso);

	void deleteCurso(Integer id);

}
