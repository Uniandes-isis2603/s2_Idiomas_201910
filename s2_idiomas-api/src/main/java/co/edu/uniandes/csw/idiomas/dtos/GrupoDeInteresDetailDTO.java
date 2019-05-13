/*
MIT License

Copyright (c) 2017 Universidad de los Andes - ISIS2603

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package co.edu.uniandes.csw.idiomas.dtos;

import co.edu.uniandes.csw.bookstore.entities.BookEntity;
import co.edu.uniandes.csw.bookstore.entities.PrizeEntity;
import co.edu.uniandes.csw.idiomas.entities.GrupoDeInteresEntity;
import co.edu.uniandes.csw.idiomas.entities.UsuarioEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Clase que extiende de {@link GrupoDeInteresDTO} para manejar las relaciones entre los
 * GrupoDeInteresDTO y otros DTOs. Para conocer el contenido de un Autor vaya a la
 * documentacion de {@link GrupoDeInteresDTO}
 *
 * @author g.cubillosb
 */
public class GrupoDeInteresDetailDTO extends GrupoDeInteresDTO implements Serializable {
    
    // -------------------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------------------
    
    /**
     * Lista, relación, de cero o muchos usuarios, contiene los usuarios asociados con 
     * el grupo de interés.
     */
    private List<UsuarioDTO> usuarios;
    
    /**
     * Lista, relación, de cero a muchas actividades, contiene las actividades
     * asociadas con el grupo de interés.
     */
    private List<ActividadDTO> actividades;

    // ------------------------------------------------------------------------
    // Constructor
    // ------------------------------------------------------------------------
    
    /**
     * Constructor vacío.
     */
    public GrupoDeInteresDetailDTO() {
        super();
    }

    /**
     * Crea un objeto GrupoDeInteresDetailDTO a partir de un objeto GrupoDeInteresEntity
     * incluyendo los atributos de GrupoDeInteresDTO.
     *
     * @param grupoDeInteresEntity Entidad GrupoDeInteresEntity desde la cual se va a crear el
     * nuevo objeto.
     *
     */
    public GrupoDeInteresDetailDTO(GrupoDeInteresEntity grupoDeInteresEntity) {
        super(grupoDeInteresEntity);
        if (grupoDeInteresEntity != null) {
            usuarios = new ArrayList<>();
            for (UsuarioEntity entityUsuarios : grupoDeInteresEntity.getUsuarios())
            {
                usuarios.add(new UsuarioDTO(entityUsuarios));
            }
        }
    }

    /**
     * Convierte un objeto GrupoDeInteresDetailDTO a GrupoDeInteresEntity incluyendo los
     * atributos de GrupoDeInteresDTO.
     *
     * @return Nueva objeto GrupoDeInteresEntity.
     *
     */
    @Override
    public GrupoDeInteresEntity toEntity() {
        GrupoDeInteresEntity grupoDeInteresEntity = super.toEntity();
        if (books != null) {
            List<BookEntity> booksEntity = new ArrayList<>();
            for (BookDTO dtoBook : books) {
                booksEntity.add(dtoBook.toEntity());
            }
            grupoDeInteresEntity.setBooks(booksEntity);
        }
        if (prizes != null) {
            List<PrizeEntity> prizesEntity = new ArrayList<>();
            for (PrizeDTO dtoPrize : prizes) {
                prizesEntity.add(dtoPrize.toEntity());
            }
            grupoDeInteresEntity.setPrizes(prizesEntity);
        }
        return grupoDeInteresEntity;
    }

/**
     * @return the usuarios
     */
    public List<UsuarioDTO> getUsuarios() {
        return usuarios;
    }

    /**
     * @param usuarios the usuarios to set
     */
    public void setUsuarios(List<UsuarioDTO> usuarios) {
        this.usuarios = usuarios;
    }

    /**
     * @return the actividades
     */
    public List<ActividadDTO> getActividades() {
        return actividades;
    }

    /**
     * @param actividades the actividades to set
     */
    public void setActividades(List<ActividadDTO> actividades) {
        this.actividades = actividades;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
