package quixada.npi.springproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quixada.npi.springproject.model.Curso;
import quixada.npi.springproject.model.Matricula;
import quixada.npi.springproject.repository.MatriculaRepository;
import quixada.npi.springproject.service.MatriculaService;

@Service
public class MatriculaServiceImpl implements MatriculaService {

	@Autowired
	private MatriculaRepository matriculaRepository;

	@Override
	public List<Matricula> findAll() {
		return matriculaRepository.findAll();
	}
	
	@Override
    public Matricula save(Matricula matricula) {
    	return matriculaRepository.save(matricula);
    }

	@Override
	public void deleteMatricula(Integer id) {
		matriculaRepository.deleteById(id);
	}
	

}
