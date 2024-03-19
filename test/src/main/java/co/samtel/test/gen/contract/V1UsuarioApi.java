package co.samtel.test.gen.contract;

import co.samtel.test.gen.type.UsuarioTypeInput;
import co.samtel.test.gen.type.UsuarioTypeResponse;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;




import java.io.InputStream;
import java.util.Map;
import java.util.List;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;


@Path("/v1/es")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2024-03-19T14:30:27.837805400-05:00[America/Bogota]", comments = "Generator version: 7.4.0")
public interface V1UsuarioApi {

    @POST
    @Path("/usuario")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response crearUsuario(@Valid UsuarioTypeInput usuarioTypeInput);

    @PUT
    @Path("/editarUsuario/{idtbl_user}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response editarUsuario(@PathParam("idtbl_user") @Min(1) Integer idtblUser,@Valid UsuarioTypeInput usuarioTypeInput);

    @DELETE
    @Path("/eliminarUsuario/{idtbl_user}")
    Response eliminarUsuario(@PathParam("idtbl_user") @Min(1) Integer idtblUser);

    @GET
    @Path("/listadoUsuarios")
    @Produces({ "application/json" })
    Response listarTodosLosUsuario();

    @GET
    @Path("/listUsuario/{idtbl_user}")
    @Produces({ "application/json" })
    Response listarUsuario(@PathParam("idtbl_user") @Min(1) Integer idtblUser);
}
