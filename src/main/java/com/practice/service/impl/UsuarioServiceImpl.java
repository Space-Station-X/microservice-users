package com.practice.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.practice.RequestDto.UserCreateRequestDto;
import com.practice.RequestDto.UserRequestDto;
import com.practice.RequestDto.UserUpdateRequestDto;
import com.practice.ResponseDto.UserCreateResponseDto;
import com.practice.ResponseDto.UserPageResponseDto;
import com.practice.ResponseDto.UserResponseDto;
import com.practice.entity.Usuario;
import com.practice.exceptions.UserNotFoundException;
import com.practice.mapper.UserMapper;
import com.practice.repository.UsuarioRepository;

import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RequiredArgsConstructor
@Service
@Validated
public class UsuarioServiceImpl implements UsuarioService{

    private final UserMapper userMapper;
    private final UsuarioRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserPageResponseDto findAllUser(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Usuario> userPage = userRepository.findAll(pageable);
        List<UserRequestDto> dto = userPage.stream().map(
                userMapper::toDto
        ).collect(Collectors.toList());
        return new UserPageResponseDto(dto, userPage.getTotalPages(), userPage.getTotalElements());
    }
    @Override
    @Transactional(readOnly = true)
    public UserCreateResponseDto createUser(UserCreateRequestDto userCreateRequestDto) {
        Usuario user = Usuario
                .builder()
                .deAlias(userCreateRequestDto.username())
                .deClave(userCreateRequestDto.password())
                .deCorreo(userCreateRequestDto.email())
                .deNombresApellidos(userCreateRequestDto.fullname())
                .deTelefono(userCreateRequestDto.phone())
                .feReg(userCreateRequestDto.registrationDate())
                .stActivo(userCreateRequestDto.isActive())
                .build();
        userRepository.save(user);
        return userMapper.toCreateResponseDto(user);
    }
    @Override
    public UserResponseDto findByUserId(Integer id) {
        Usuario user = userRepository.findByIdUsuario(id).orElseThrow(() -> new
                UserNotFoundException("Usuario con id " + id + " no encontrado"));
        return userMapper.toDtoClient(user);
    }
    @Override
    public UserResponseDto updateUser(Integer id, UserUpdateRequestDto userUpdateRequestDto) {
        Usuario user = userRepository.findByIdUsuario(id)
                .orElseThrow(() -> new UserNotFoundException("No se encontró el usuario con id: " + id));

        updateUserFields(user, userUpdateRequestDto);

        Usuario updatedUser = userRepository.save(user);
        return userMapper.toDtoClient(updatedUser);
    }

    private void updateUserFields(Usuario user, UserUpdateRequestDto dto) {        
        if (dto.username() != null) {
            user.setDeAlias(dto.username());
        }
        if (dto.password() != null) {
            user.setDeClave(dto.password());
        }
        if (dto.email() != null) {
            user.setDeCorreo(dto.email());
        }
        if (dto.fullname() != null) {
            user.setDeNombresApellidos(dto.fullname());
        }
        if (dto.phone() != null) {
            user.setDeTelefono(dto.phone());
        }
        if (dto.registrationDate() != null) {
            user.setFeReg(dto.registrationDate());
        }
        if (dto.isActive() != null) {
            user.setStActivo(dto.isActive());
        }
    }
    @Override
    public void deleteUser(Integer id) {
        if (!userRepository.existsByIdUsuario(id)) {
            throw new UserNotFoundException("Usuario con id " + id + " no existe");
        }
        userRepository.deleteById(id);
    }

    /*@Override
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
    }*/
    
}
