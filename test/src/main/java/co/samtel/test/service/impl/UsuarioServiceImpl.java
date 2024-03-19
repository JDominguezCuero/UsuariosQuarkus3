package co.samtel.test.service.impl;

import co.samtel.test.dao.UsuarioDao;
import co.samtel.test.entity.Usuario;
import co.samtel.test.gen.type.UsuarioTypeInput;
import co.samtel.test.gen.type.UsuarioTypeResponse;
import co.samtel.test.service.contract.IUsuarioService;
import co.samtel.test.utils.ApplicationException;
import co.samtel.test.utils.UsuarioMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.Collections;
import java.util.List;

import static co.samtel.test.constant.Constant.ERROR_SERVICIO;
@ApplicationScoped
public class UsuarioServiceImpl implements IUsuarioService {
    private static final Logger LOG = LoggerFactory.getLogger(UsuarioServiceImpl.class);
    @Inject
    UsuarioDao usuarioDao;
    @Inject
    UsuarioMapper usuarioMapper;
    @Transactional
    public UsuarioTypeResponse crearUsuario(UsuarioTypeInput usuarioTypeInput) {
        LOG.info("Inicia crearUsuario Impl");
        try {
            Usuario usuario = usuarioMapper.usuarioTypeToEntity(usuarioTypeInput);
            usuarioDao.persist(usuario);
            UsuarioTypeResponse usuarioTypeResponses = usuarioMapper.usuarioEntityToTypeResponse(usuario);
            LOG.info("Finaliza crearUsuario Impl");
            return  usuarioTypeResponses;
        }catch (ApplicationException e){
            LOG.error("Error al crear usuario");
            throw new ApplicationException(ERROR_SERVICIO + e.getMessage());
        }
    }
    @Transactional
    public List<UsuarioTypeResponse> listarUsuario(Integer idtblUser){
        LOG.info("Inicia listarUsuario Impl");

        try {
            Usuario usuario = usuarioDao.findById(idtblUser.longValue());
            UsuarioTypeResponse response = usuarioMapper.usuarioEntityToTypeResponse(usuario);
            LOG.info("Finaliza listar usuario por id Impl");
            return  Collections.singletonList(response);
        }catch (ApplicationException e){
            LOG.error("Se presento un error al listar usuario por id"+ e.getMessage());
            throw new ApplicationException(ERROR_SERVICIO + e.getMessage());
        }
    }
}
