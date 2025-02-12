package com.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.RequestDto.UserCreateRequestDto;
import com.practice.RequestDto.UserUpdateRequestDto;
import com.practice.ResponseDto.UserCreateResponseDto;
import com.practice.ResponseDto.UserPageResponseDto;
import com.practice.ResponseDto.UserResponseDto;
import com.practice.entity.Usuario;
import com.practice.service.impl.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
@Validated
@Tag(name = "Usuarios", description = "Usuarios  API")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Operation(summary = "Obtener todo los usuarios", description = "Devuelve todo los usuarios")
    @ApiResponse(responseCode = "200", description = "Usuarios obtenidos correctamente")
    @ApiResponse(responseCode = "404", description = "No se encontraron usuarios")
    @GetMapping("")
    public ResponseEntity<UserPageResponseDto> findAllUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        UserPageResponseDto response = usuarioService.findAllUser(page, size);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(summary = "Obtener  usuario por ID", description = "Devuelve usuarios por ID")
    @ApiResponse(responseCode = "200", description = "Usuario obtenido correctamente")
    @ApiResponse(responseCode = "404", description = "No se encontró el usuario")
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findByUserId(@PathVariable Integer id) {
        UserResponseDto response = usuarioService.findByUserId(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /*@GetMapping("/alias/{username}")
    public Usuario obtenerUsuarioPorId(@PathVariable String username) {
        return usuarioService.obtenerUsuarioPorAlias(username);
    }*/

    @Operation(summary = "Crear un usuario", description = "Crea  un  usuario")
    @ApiResponse(responseCode = "200", description = "Usuario creado correctamente")
    @ApiResponse(responseCode = "404", description = "No se pudo crear el usuario")
    @PostMapping("")
    public ResponseEntity<UserCreateResponseDto> createUser(@RequestBody @Valid UserCreateRequestDto userCreateRequestDto) {
        UserCreateResponseDto response = usuarioService.createUser(userCreateRequestDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    
    @Operation(summary = "Actualiza un usuario", description = "Actualiza  un usuario por ID")
    @ApiResponse(responseCode = "200", description = "Usuario actualizado correctamente")
    @ApiResponse(responseCode = "404", description = "No se pudo actualizar el usuario")
    @PatchMapping("/{id}")
    public ResponseEntity<UserResponseDto> updateUserById(@PathVariable Integer id, @RequestBody @Valid UserUpdateRequestDto userUpdateRequestDto) {
        UserResponseDto response = usuarioService.updateUser(id, userUpdateRequestDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(summary = "Elimina un usuario por ID", description = "Elimina un usuario por ID")
    @ApiResponse(responseCode = "200", description = "Usuario eliminado correctamente")
    @ApiResponse(responseCode = "404", description = "No se encontró el usuario")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteByUserId(@PathVariable Integer id) {
        usuarioService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
