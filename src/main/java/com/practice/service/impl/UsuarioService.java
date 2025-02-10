package com.practice.service.impl;

import java.util.List;

import com.practice.entity.Usuario;

public interface UsuarioService {
    public List<Usuario> listarUsuarios();
    public Usuario obtenerUsuarioPorId(Integer id);
    public Usuario obtenerUsuarioPorAlias(String alias);
    public Usuario guardarUsuario(Usuario usuario);
    public Usuario actualizarUsuario(Integer id,Usuario usuario);
    public Usuario eliminarUsuario(Integer id);
}
