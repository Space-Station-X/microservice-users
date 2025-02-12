package com.practice.repository;

import com.practice.entity.Usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
    Optional<Usuario> findByDeAlias(String user);
    Optional<Usuario> findByIdUsuario(Integer user);
    boolean existsByIdUsuario(Integer user);
}
