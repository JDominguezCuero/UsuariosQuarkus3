package co.samtel.test.service.contract;

import co.samtel.test.gen.type.UsuarioTypeInput;
import co.samtel.test.gen.type.UsuarioTypeResponse;

import java.util.List;

public interface IUsuarioService {
    UsuarioTypeResponse crearUsuario(UsuarioTypeInput usuarioTypeInput);
    List<UsuarioTypeResponse> listarTodosLosUsuarios();
    List<UsuarioTypeResponse> listarUsuario(Integer idtblUser);
    List<UsuarioTypeResponse> editarUsuario(Integer idtblUser, UsuarioTypeInput usuarioTypeInput);
    void eliminarUsuario(Integer idtblUser);
}
