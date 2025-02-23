package com.practice.service.impl;

import com.practice.RequestDto.*;
import com.practice.ResponseDto.*;

public interface UsuarioService {
    /*public List<Usuario> listarUsuarios();
    public Usuario obtenerUsuarioPorId(Integer id);
    public Usuario obtenerUsuarioPorAlias(String alias);
    public Usuario guardarUsuario(Usuario usuario);
    public Usuario actualizarUsuario(Integer id,Usuario usuario);
    public Usuario eliminarUsuario(Integer id);*/
    UserPageResponseDto findAllUser(int page, int size);

    UserCreateResponseDto createUser(UserCreateRequestDto userCreateRequestDto);

    UserResponseDto findByUserId(Integer id);

    UserResponseDto updateUser(Integer id, UserUpdateRequestDto userUpdateRequestDto);

    void deleteUser(Integer id);
}
