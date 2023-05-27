package com.br.arsenal.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.arsenal.modelos.Repositorio.UsuarioRepositorio;
import com.br.arsenal.modelos.entidades.Usuario;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/Usuarios")
public class UsuarioControlador {

    @Autowired
    UsuarioRepositorio usuarioRep;

    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> mostrarUsuarios(){
        List<Usuario> lista = usuarioRep.findAll();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping("/mostrarUsuario/{id}")
    public ResponseEntity<Optional<Usuario>> mostrarUsuarioId(@PathVariable Long id){
        Optional<Usuario> Usuario = usuarioRep.findById(id);
        return ResponseEntity.ok().body(Usuario);
    }
    @PostMapping
    public void salvarUsuario(@RequestBody Usuario Usuario){
        usuarioRep.save(Usuario);
    }

    @PutMapping
    public void atualizarUsuario(@RequestBody Usuario Usuario){
        usuarioRep.save(Usuario);
    }

    @DeleteMapping("deletarUsuario/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id){
        usuarioRep.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/tokenAtivacao")
    public ResponseEntity<Boolean> verificarTokenAtivacao(@RequestParam String usuario, @RequestParam String senha) {
        Usuario usuarioEncontrado = usuarioRep.buscarLogin(usuario, senha);
        boolean isValid = usuarioEncontrado != null;
        return ResponseEntity.ok().body(isValid);
    }

}
