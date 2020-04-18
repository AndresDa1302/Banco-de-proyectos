/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.Rol;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.persistence.DaoUsuario;
import edu.eci.cvds.samples.persistence.PersistenceException;
import edu.eci.cvds.samples.services.ExcepcionServiciosBanco;
import edu.eci.cvds.samples.services.ServiciosBanco;
import java.util.List;

/**
 *
 * @author Andres Gonzalez
 */
public class ServiciosBancoImpl implements ServiciosBanco {
    
    @Inject
    private DaoUsuario daoUsuario;

    @Override
    public Usuario consultarUsuario(String correo, String clave) throws ExcepcionServiciosBanco {
        try{
            return daoUsuario.consultarUsuario(correo,clave);
        }catch(PersistenceException ex){
            throw new ExcepcionServiciosBanco("No se pudo consultar el usuario "+correo,ex);
        }
    }

    @Override
    public List<Usuario> consultarUsuarios() throws ExcepcionServiciosBanco {
        try{
            return daoUsuario.consultarUsuarios();
        }catch(PersistenceException ex){
            throw new ExcepcionServiciosBanco("No se pudo consultar los usuarios ",ex);
        }
    }

    @Override
    public void cambiarRol(Usuario usuario, Rol rol) throws ExcepcionServiciosBanco {
        try{
            daoUsuario.cambiarRol(usuario,rol);
        }catch(PersistenceException ex){
            throw new ExcepcionServiciosBanco("No se pudo cambiar el rol del usuario "+usuario.getCorreo(),ex);
        }    
    }


    
}
