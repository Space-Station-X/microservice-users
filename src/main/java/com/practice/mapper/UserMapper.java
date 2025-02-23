package com.practice.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

import com.practice.RequestDto.UserRequestDto;
import com.practice.ResponseDto.UserResponseDto;
import com.practice.ResponseDto.UserCreateResponseDto;
import com.practice.entity.Usuario;

@Component
public class UserMapper {
    private final ModelMapper modelMapper;

    public UserMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        modelMapper.addMappings(new PropertyMap<Usuario, UserRequestDto>() {
            @Override
            protected void configure() {
                map().setUserId((source.getIdUsuario()));
                map().setUsername((source.getDeAlias()));
                map().setPassword((source.getDeClave()));
                map().setEmail((source.getDeCorreo()));
                map().setFullname((source.getDeNombresApellidos()));
                map().setPhone((source.getDeTelefono()));
                map().setRegistrationDate((source.getFeReg()));
                map().setIsActive((source.getStActivo()));
            }
        });
        modelMapper.addMappings(new PropertyMap<Usuario, UserResponseDto>() {
            @Override
            protected void configure() {
                map().setUserId((source.getIdUsuario()));
                map().setUsername((source.getDeAlias()));
                map().setPassword((source.getDeClave()));
                map().setEmail((source.getDeCorreo()));
                map().setFullname((source.getDeNombresApellidos()));
                map().setPhone((source.getDeTelefono()));
                map().setRegistrationDate((source.getFeReg()));
                map().setIsActive((source.getStActivo()));
            }
        });
        modelMapper.addMappings(new PropertyMap<Usuario, UserCreateResponseDto>() {
            @Override
            protected void configure() {
                map().setUserId((source.getIdUsuario()));
                map().setUsername((source.getDeAlias()));
                map().setPassword((source.getDeClave()));
                map().setEmail((source.getDeCorreo()));
                map().setFullname((source.getDeNombresApellidos()));
                map().setPhone((source.getDeTelefono()));
                map().setRegistrationDate((source.getFeReg()));
                map().setIsActive((source.getStActivo()));
            }
        });
    }

    public UserRequestDto toDto(Usuario user) {
        return modelMapper.map(user, UserRequestDto.class);
    }

    public UserResponseDto toDtoClient(Usuario user) {
        return modelMapper.map(user, UserResponseDto.class);
    }
    public UserCreateResponseDto toCreateResponseDto(Usuario user){
        return modelMapper.map(user,UserCreateResponseDto.class);
    }
}
