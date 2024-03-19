package co.samtel.test.service.contract;

import co.samtel.test.gen.type.UsuarioTypeInput;
import co.samtel.test.gen.type.UsuarioTypeResponse;

import java.util.List;

public interface IUsuarioService {
    UsuarioTypeResponse crearUsuario(UsuarioTypeInput usuarioTypeInput);
    List<UsuarioTypeResponse> listarUsuario(Integer idtblUser);
}
