/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.persistence.mybatisimpl.mappers;

import edu.eci.cvds.samples.entities.Usuario;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author Andres Gonzalez
 */
public interface UsuarioMapper {

    public Usuario consultarUsuario(@Param("corr")String correo, @Param("clusu")String clave);
    
}
