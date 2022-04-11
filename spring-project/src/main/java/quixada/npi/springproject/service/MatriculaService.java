package quixada.npi.springproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import quixada.npi.springproject.model.Matricula;

@Service
public interface MatriculaService {

	List<Matricula> findAll();

	Matricula save(Matricula matricula);

}
