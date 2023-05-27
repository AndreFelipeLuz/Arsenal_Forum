package com.br.arsenal.modelos.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.br.arsenal.modelos.entidades.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
    
    @Query("SELECT u FROM Usuario u WHERE u.usuario = :usuario AND u.senha = :senha")
    public Usuario buscarLogin(String usuario, String senha);
}