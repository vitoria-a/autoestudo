package quixada.npi.springproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import quixada.npi.springproject.model.Curso;

public interface CursoRepository extends JpaRepository <Curso, Integer> {

	List<Curso> findAll();

	Curso save(Curso curso);

}