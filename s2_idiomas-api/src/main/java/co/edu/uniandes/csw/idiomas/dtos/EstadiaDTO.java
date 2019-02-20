/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.idiomas.dtos;

/**
 * EstadiaDTO Objeto de transferencia de datos de la actividad. Los DTO contienen
 * las representaciones de los JSON que se transfieren entre el cliente y el
 * servidor.
 * @author g.cubillosb
 */
public class EstadiaDTO extends ActividadDTO{
    
    // -------------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------------
    
    /**
     * Atributo que indica el pais en el que se va a realizar la estadia
     */
    private String pais;
    
    //---------------------------------------------------------------------
    // Constructor
    // --------------------------------------------------------------------
    
    /**
     * Constructor vacio
     */
    public EstadiaDTO ()
    {
        
    }
    
}
