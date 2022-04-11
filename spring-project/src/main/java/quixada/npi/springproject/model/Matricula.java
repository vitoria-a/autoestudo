package quixada.npi.springproject.model;

import javax.persistence.Id;

public class Matricula {
	
	private Integer id_user;
	
	private Integer id_curso;
	
	public Matricula() {
		super();
	}

	public Matricula(Integer id_user, Integer id_curso) {
		super();
		this.id_user = id_user;
		this.id_curso = id_curso;
	}

	public Integer getId_user() {
		return id_user;
	}

	public void setId_user(Integer id_user) {
		this.id_user = id_user;
	}

	public Integer getId_cursoInteger() {
		return id_curso;
	}

	public void setId_cursoInteger(Integer id_curso) {
		this.id_curso = id_curso;
	}
}
