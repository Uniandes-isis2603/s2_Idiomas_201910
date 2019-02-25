/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.idiomas.dtos;

import java.io.Serializable;

/**
 * ActividadDTO Objeto de transferencia de datos de la actividad. Los DTO contienen
 * las representaciones de los JSON que se transfieren entre el cliente y el
 * servidor.
 * @author g.cubillosb
 */
public class ActividadDTO implements Serializable{
    
    // -----------------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------------
    
    /**
     * Atributo que contiene la fecha
     */
    private String fecha;
    
    /**
     * Atributo que contiene la descripcion de la actividad
     */
    private String descripcion;
    
    /**
     * Atributo que contiene la motivacion de la actvidad
     */
    private String motivacion;
    
    // -----------------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------------
    
    /**
     * Constructor vacio de una actividad
     */
    public ActividadDTO ()
    {
        
    }
    
    /**
     * Construye un objeto ActividadDTO con la información pasada por parámetro.
     * 
     * @param pFecha La fecha en la que se va a realizar la actividad.
     * @param pDescripcion La descripción de la actividad.
     * @param pMotivacion La razón por la que se va a realizar la actividad.
     */
    public ActividadDTO (String pFecha, String pDescripcion, String pMotivacion)
    {
        fecha = pFecha;
        descripcion = pDescripcion;
        motivacion = pMotivacion;
    }
    
    // ----------------------------------------------------------------------
    // Metodos
    // ----------------------------------------------------------------------

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the motivacion
     */
    public String getMotivacion() {
        return motivacion;
    }

    /**
     * @param motivacion the motivacion to set
     */
    public void setMotivacion(String motivacion) {
        this.motivacion = motivacion;
    }
    
    
}
