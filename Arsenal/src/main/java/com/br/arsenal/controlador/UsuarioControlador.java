package com.br.arsenal.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.arsenal.modelos.Repositorio.UsuarioRepositorio;
import com.br.arsenal.modelos.entidades.Usuario;

import java.util.List;
import java.util.Optional;


@RestController

public class UsuarioControlador {

    @Autowired
    UsuarioRepositorio usuarioRep;

    @GetMapping("/mostrarUsuarios")
    public ResponseEntity<List<Usuario>> mostrarUsuarios(){
        List<Usuario> lista = usuarioRep.findAll();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping("/mostrarUsuario/{id}")
    public ResponseEntity<Optional<Usuario>> mostrarUsuarioId(@PathVariable Long id){
        Optional<Usuario> Usuario = usuarioRep.findById(id);
        return ResponseEntity.ok().body(Usuario);
    }

    @PostMapping("/salvarUsuario")
    public void salvarUsuario(@RequestBody Usuario Usuario){
        usuarioRep.save(Usuario);
    }

    @PutMapping("/atualizarUsuario")
    public void atualizarUsuario(@RequestBody Usuario Usuario){
        usuarioRep.save(Usuario);
    }

    @DeleteMapping("deletarUsuario/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id){
        usuarioRep.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
