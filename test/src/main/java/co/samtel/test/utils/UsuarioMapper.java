package co.samtel.test.utils;

import co.samtel.test.entity.Usuario;
import co.samtel.test.gen.type.UsuarioTypeInput;
import co.samtel.test.gen.type.UsuarioTypeResponse;
import jakarta.enterprise.context.ApplicationScoped;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class UsuarioMapper {

    public Usuario usuarioTypeToEntity(UsuarioTypeInput usuarioTypeInput){
        return  new ModelMapper().map(usuarioTypeInput, Usuario.class);
    }
    public UsuarioTypeResponse usuarioEntityToTypeResponse(Usuario usuario) {
        return new ModelMapper().map(usuario, UsuarioTypeResponse.class);
    }

    public List<UsuarioTypeResponse> usuarioTypeListEntityToTypeResponse(List<Usuario> listUsuarios ){
        List<UsuarioTypeResponse> usuariosTypeResponseList = new ArrayList<>();

        for (Usuario usuario: listUsuarios){
            UsuarioTypeResponse response = new ModelMapper().map(usuario, UsuarioTypeResponse.class);
            usuariosTypeResponseList.add(response);
        }

        return usuariosTypeResponseList;
    }
}
