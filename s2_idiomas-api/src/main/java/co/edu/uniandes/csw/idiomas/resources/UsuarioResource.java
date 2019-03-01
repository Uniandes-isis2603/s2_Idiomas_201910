/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.idiomas.resources;



import co.edu.uniandes.csw.idiomas.dtos.UsuarioDTO;
//import co.edu.uniandes.csw.idiomas.ejb.UsuarioLogic;
//import co.edu.uniandes.csw.idiomas.entities.UsuarioEntity;
import co.edu.uniandes.csw.idiomas.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.idiomas.mappers.BusinessLogicExceptionMapper;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * Clase que implementa el recurso "usuarios".
 *
 * @author ISIS2603
 * @version 1.0
 */
@Path("usuarios")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class UsuarioResource
{
 private static final Logger LOGGER = Logger.getLogger(UsuarioResource.class.getName());

//    @Inject
//    UsuarioLogic usuarioLogic; // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.

    /**
     * Crea una nueva usuario con la informacion que se recibe en el cuerpo de
     * la petición y se regresa un objeto identico con un id auto-generado por
     * la base de datos.
     *
     * @param usuario {@link UsuarioDTO} - La usuario que se desea
     * guardar.
     * @return JSON {@link UsuarioDTO} - La usuario guardada con el atributo
     * id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} -
     * Error de lógica que se genera cuando ya existe la usuario.
     */
    @POST
    public UsuarioDTO createUsuario(UsuarioDTO usuario) throws BusinessLogicException {
       
        return usuario;
    }

    /**
     * Borra la usuario con el id asociado recibido en la URL.
     *
     * @param usuariosId Identificador de la usuario que se desea borrar.
     * Este debe ser una cadena de dígitos.
     * @return 
     */
    @DELETE
    @Path("{usuariosId: \\d+}")
    public long deleteUsuario(@PathParam("usuariosId") Long usuariosId) {
        return usuariosId;
    }
    
    /**
     * Actualiza la usuario con el id asociado recibido en la URL.
     *
     * @param usuariosId Identificador de la usuario que se desea actualizar.
     * Este debe ser una cadena de dígitos.
     * @return 
     */
    @PUT
    @Path("{usuariosId: \\d+}")
    public long updateUsuario(@PathParam("usuariosId") Long usuariosId) {
        return usuariosId;
    }
    
     /**
     * Actualiza la usuario con el id asociado recibido en la URL.
     *
     * @param usuariosId Identificador de la usuario que se desea actualizar.
     * Este debe ser una cadena de dígitos.
     * @return 
     */
    @GET
    @Path("{usuariosId: \\d+}")
    public long retornarUsuario(@PathParam("usuariosId") Long usuariosId) {
        return usuariosId;
    }
    
      /**
     * Actualiza la usuario con el id asociado recibido en la URL.
     *
     * @param usuariosId Identificador de la usuario que se desea actualizar.
     * Este debe ser una cadena de dígitos.
     * @return 
     */
    @GET    
    public UsuarioDTO[] retornarUsuario() {
        return new UsuarioDTO[1];        
    }   
    
}
