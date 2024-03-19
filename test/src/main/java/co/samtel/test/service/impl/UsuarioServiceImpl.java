package co.samtel.test.service.impl;

import co.samtel.test.dao.UsuarioDao;
import co.samtel.test.entity.Usuario;
import co.samtel.test.gen.type.UsuarioTypeInput;
import co.samtel.test.gen.type.UsuarioTypeResponse;
import co.samtel.test.service.contract.IUsuarioService;
import co.samtel.test.utils.ApplicationException;
import co.samtel.test.utils.UsuarioMapper;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
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

    public List<UsuarioTypeResponse> listarTodosLosUsuarios() {
        LOG.info("Inicia listarTodosLosUsuarios Impl.");

        try{
            PanacheQuery query = usuarioDao.findAll();
            List<Usuario> listUsuarios = query.list();
            LOG.info("Termina listarTodosLosUsuarios Impl.");

            return usuarioMapper.usuarioTypeListEntityToTypeResponse(listUsuarios);
        }catch (ApplicationException e){
            LOG.error("Ha ocurrido un error en listarTodosLosUsuarios Impl:" + e.getMessage());
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

    @Transactional
    public List<UsuarioTypeResponse> editarUsuario(Integer idtblUser, UsuarioTypeInput usuarioTypeInput) {
        LOG.info("Inicia editarUsuario Impl.");

        try {
            Usuario usuario = usuarioDao.findById(idtblUser.longValue());
            Usuario usuarioCamb = usuarioMapper.usuarioTypeToEntity(usuarioTypeInput);

            usuario.setName(usuarioCamb.getName());
            usuario.setLastname(usuarioCamb.getLastname());
            usuario.setCreateat(usuarioCamb.getCreateat());

            UsuarioTypeResponse usuarioTypeResponse = usuarioMapper.usuarioEntityToTypeResponse(usuarioCamb);
            LOG.info("Finaliza editarUsuario Impl.");

            return Collections.singletonList(usuarioTypeResponse);
        }catch (ApplicationException e){
            LOG.error("Ha ocurrido en editarUsuario: "+e.getMessage());
            throw new ApplicationException(ERROR_SERVICIO + e.getMessage());
        }
    }

    @Transactional
    public void eliminarUsuario(Integer idtblUser) {
        LOG.info("Inicia eliminarUsuario Impl.");

        try{
            usuarioDao.deleteById(idtblUser.longValue());
            LOG.info("Termina eliminarUsuario Impl.");
        }catch (ApplicationException e){
            LOG.error("Ha ocurrido un error en eliminarUsuario: "+e.getMessage());
            throw new ApplicationException(ERROR_SERVICIO + e.getMessage());
        }
    }
}
