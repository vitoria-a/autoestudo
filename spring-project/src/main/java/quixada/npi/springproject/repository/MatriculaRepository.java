package quixada.npi.springproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import quixada.npi.springproject.model.Matricula;

public interface MatriculaRepository extends JpaRepository<Matricula, Integer> {

	List<Matricula> findAll();

	Matricula save();

}
