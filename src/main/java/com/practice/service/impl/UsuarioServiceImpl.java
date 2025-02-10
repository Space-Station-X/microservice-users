package com.practice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.entity.Usuario;
import com.practice.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    public UsuarioRepository usuarioRepository;
    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario obtenerUsuarioPorId(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public Usuario obtenerUsuarioPorAlias(String alias) {
        return usuarioRepository.findByDeAlias(alias);
    }

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario actualizarUsuario(Integer id, Usuario usuario) {
        Usuario usuarioExiste = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (usuario.getDeAlias() != null) {
            usuarioExiste.setDeAlias(usuario.getDeAlias());
        }
        if (usuario.getDeClave() != null) {
            usuarioExiste.setDeClave(usuario.getDeClave());
        }
        if (usuario.getDeCorreo() != null) {
            usuarioExiste.setDeCorreo(usuario.getDeCorreo());
        }
        if (usuario.getDeNombresApellidos() != null) {
            usuarioExiste.setDeNombresApellidos(usuario.getDeNombresApellidos());
        }
        if (usuario.getDeTelefono() != null) {
            usuarioExiste.setDeTelefono(usuario.getDeTelefono());
        }
        if (usuario.getStActivo() != null) {
            usuarioExiste.setStActivo(usuario.getStActivo());
        }
        return usuarioRepository.save(usuarioExiste);
    }

    @Override
    public Usuario eliminarUsuario(Integer id) {
        Usuario usuarioExiste = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuarioExiste.setStActivo("N");
        return usuarioRepository.save(usuarioExiste);
    }
    
}
