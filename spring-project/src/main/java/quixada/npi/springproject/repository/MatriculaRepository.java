package quixada.npi.springproject.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import quixada.npi.springproject.model.Matricula;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Integer> {

	List<Matricula> findAll();

}
