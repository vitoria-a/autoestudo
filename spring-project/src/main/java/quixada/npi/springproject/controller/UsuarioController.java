package quixada.npi.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import quixada.npi.springproject.model.Usuario;
import quixada.npi.springproject.service.UsuarioService;

import java.util.List;


@RestController
@RequestMapping("/usuarios")

public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("")
    public List<Usuario> findAll() {
        return usuarioService.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<List<Usuario>> find(@PathVariable Integer id) {
        // Busca usuário pelo id e retornar usuário...
        return ResponseEntity.ok().build();
    }

    @PostMapping("")
    public Usuario save(@RequestBody Usuario usuario) {
       // Cadastrar usuário e retornar usuário cadastrado...
       return usuarioService.save(usuario);
    }

    @DeleteMapping("{id}")
    //TODO: excluir usuário
    public void deleteUser(@PathVariable Integer id) {
    	usuarioService.deleteUser(id);
    }
    
    @PutMapping("{id}")
    public Usuario update(@RequestBody Usuario usuario) {
    	return usuarioService.save(usuario);
    }
    



}
