package quixada.npi.springproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quixada.npi.springproject.model.Curso;
import quixada.npi.springproject.repository.CursoRepository;
import quixada.npi.springproject.service.CursoService;

@Service
public class CursoServiceImpl implements CursoService {
	
	@Autowired
    private CursoRepository cursoRepository;

    @Override
    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }
    
    @Override
    public Curso save(Curso curso) {
    	return cursoRepository.save(curso);
    }
    
    @Override
    public void deleteCurso(Integer id) {
    	cursoRepository.deleteById(id);
    } 

}