/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.idiomas.entities;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author estudiante
 */
public class GrupoDeInteresEntity extends BaseEntity implements Serializable{
    /**
     * idioma del grupo
     */
    String idioma;
    /**
     * administrador del grupo
     */
    String administrador;
    /**
     * calificacion del grupo
     */
    Long calificacion;
    /**
     * blog del grupo
     */
    Long blog;

    /**
     * Connstructor vacio de un Entity
     */
    public GrupoDeInteresEntity()
    {
        
    }
    /**
     * 
     * @return idioma
     */
    public String getIdioma() {
        return idioma;
    }
    /**
     * 
     * @param idioma 
     */
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
   /**
     * 
     * @return administrador
     */
    public String getAdministrador() {
        return administrador;
    }
    /**
     * 
     * @param administrador 
     */
    public void setAdministrador(String administrador) {
        this.administrador = administrador;
    }
   /**
     * 
     * @return calificacion
     */
    public Long getCalificacion() {
        return calificacion;
    }
    /**
     * 
     * @param calificacion 
     */
    public void setCalificacion(Long calificacion) {
        this.calificacion = calificacion;
    }
   /**
     * 
     * @return blog
     */
    public Long getBlog() {
        return blog;
    }
    /**
     * 
     * @param blog 
     */
    public void setBlog(Long blog) {
        this.blog = blog;
    }

}
