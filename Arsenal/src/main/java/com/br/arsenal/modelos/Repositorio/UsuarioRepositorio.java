package com.br.arsenal.modelos.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.arsenal.modelos.entidades.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
    
}
