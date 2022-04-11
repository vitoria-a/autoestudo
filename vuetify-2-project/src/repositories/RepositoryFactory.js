import UsuarioRepository from "./usuarioRepository";
import CursoRepository from "./cursoRepository"
import MatriculaRepository  from "./matriculaRepository";

const repositories = {
    usuario: UsuarioRepository,
    curso: CursoRepository,
    matricula: MatriculaRepository
};

export const RepositoryFactory = {
    get: name => repositories[name]
};
