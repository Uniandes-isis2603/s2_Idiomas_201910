/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.idiomas.resources;

import co.edu.uniandes.csw.idiomas.dtos.ComentarioGrupoDTO;
import co.edu.uniandes.csw.idiomas.ejb.ComentarioGrupoLogic;
import co.edu.uniandes.csw.idiomas.entities.ComentarioGrupoEntity;
import co.edu.uniandes.csw.idiomas.exceptions.BusinessLogicException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Santiago Gamboa
 */

@Path("GrupoComments")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped

public class ComentarioGrupoResource {
    
    private static final Logger LOGGER = Logger.getLogger(ComentarioGrupoResource.class.getName());
    
     @Inject
    private ComentarioGrupoLogic logica;
    
    /**
     * Crea una nueva comment con la informacion que se recibe en el cuerpo de
     * la petición y se regresa un objeto identico con un id auto-generado por
     * la base de datos.
     *
     * @param comentario {@link commentDTO} - La comment que se desea
     * guardar.
     * @return JSON {@link commentDTO} - La comment guardada con el atributo
     * id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} -
     * Error de lógica que se genera cuando ya existe la comment.
     */
    @POST
    public ComentarioGrupoDTO createComment(ComentarioGrupoDTO comentario) throws BusinessLogicException 
    {
        LOGGER.log(Level.INFO, "commentResource createcomment: input: {0}", comentario);
        // Convierte el DTO (json) en un objeto Entity para ser manejado por la lógica.
        ComentarioGrupoEntity comentarioEntity = comentario.toEntity();
        // Invoca la lógica para crear un comentario nuevo
        ComentarioGrupoEntity comentarioCalifEntity = logica.createGroupComment(comentarioEntity);
        // Como debe retornar un DTO (json) se invoca el constructor del DTO con argumento el entity nuevo
        ComentarioGrupoDTO comentarioDTO = new ComentarioGrupoDTO(comentarioCalifEntity);
        LOGGER.log(Level.INFO, "ComentarioResource createcomment: output: {0}", comentarioDTO);
        return comentarioDTO;
    }
    
    /**
     * Busca el comentario con el id asociado recibido en la URL y la devuelve.
     *
     * @param commentId Identificador de la comment que se esta buscando.
     * Este debe ser una cadena de dígitos.
     * @return JSON {@link commentDetailDTO} - La comment buscada
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra la comment.
     */
    @GET
    @Path("{califCommentId: \\d+}")
    public ComentarioGrupoDTO getcomment(@PathParam("commentId") Long commentId)
    {
        LOGGER.log(Level.INFO, "ComentarioResource getComment: input: {0}", commentId);
        ComentarioGrupoEntity comentarioEntity = logica.getComentario(commentId);
        if (comentarioEntity == null) {
            throw new WebApplicationException("El recurso /comments/" + commentId + " no existe.", 404);
        }
        ComentarioGrupoDTO detailDTO = new ComentarioGrupoDTO(comentarioEntity);
        LOGGER.log(Level.INFO, "commentResource getcomment: output: {0}", detailDTO);
        return detailDTO;
    }
    
    /**
     * Borra el comentario con el id asociado recibido en la URL.
     *
     * @param commentId Identificador de la comment que se desea borrar.
     * Este debe ser una cadena de dígitos.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} -
     * Error de lógica que se genera cuando no se puede eliminar la comment.
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra la comment.
     */
    @DELETE
    @Path("{commentsId: \\d+}")
    public void deletecomment(@PathParam("commentsId") Long commentId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "commentResource deletecomment: input: {0}", commentId);
        if (logica.getComentario(commentId) == null) {
            throw new WebApplicationException("El recurso /comments/" + commentId + " no existe.", 404);
        }
        logica.deleteComment(commentId);
        LOGGER.info("commentResource deletecomment: output: void");
    }
    
     /**
     * Actualiza la comentario con el id recibido en la URL con la informacion
     * que se recibe en el cuerpo de la petición.
     *
     * @param commentId Identificador de la comment que se desea
     * actualizar. Este debe ser una cadena de dígitos.
     * @param comentario {@link commentDetailDTO} La comment que se desea
     * guardar.
     * @return JSON {@link commentDetailDTO} - La comment guardada.
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra la comment a
     * actualizar.
     */
    @PUT
    @Path("{commentsId: \\d+}")
    public ComentarioGrupoDTO updatecomment(@PathParam("commentsId") Long commentId, ComentarioGrupoDTO comentario) 
    {
        LOGGER.log(Level.INFO, "ComentarioResource updatecomment: input: id:{0} , comment: {1}", new Object[]{commentId, comentario});
        comentario.setId(commentId);
        if (logica.getComentario(commentId) == null) {
            throw new WebApplicationException("El recurso /comments/" + commentId + " no existe.", 404);
        }
        ComentarioGrupoDTO detailDTO = new ComentarioGrupoDTO(logica.updateComment(commentId, comentario.toEntity()));
        LOGGER.log(Level.INFO, "commentResource updatecomment: output: {0}", detailDTO);
        return detailDTO;

    }
}
