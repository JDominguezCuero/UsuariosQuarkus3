package co.samtel.test.dao;

import co.samtel.test.entity.Usuario;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UsuarioDao implements PanacheRepository<Usuario> {
}
