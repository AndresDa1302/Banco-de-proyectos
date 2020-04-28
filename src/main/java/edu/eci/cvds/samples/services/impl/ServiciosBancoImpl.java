/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.Iniciativa;
import edu.eci.cvds.samples.entities.Like;
import edu.eci.cvds.samples.entities.Rol;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.persistence.*;
import edu.eci.cvds.samples.persistence.DaoIniciativa;
import edu.eci.cvds.samples.services.ExcepcionServiciosBanco;
import edu.eci.cvds.samples.services.ServiciosBanco;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andres Gonzalez
 */
public class ServiciosBancoImpl implements ServiciosBanco {
    
    @Inject
    private DaoUsuario daoUsuario;
    @Inject
    private DaoIniciativa daoIniciativa;
    @Inject
    private DaoLike daoLike;

    @Override
    public Usuario consultarUsuario(String correo ) throws ExcepcionServiciosBanco {
        try{
            return daoUsuario.consultarUsuario(correo);
        }catch(PersistenceException ex){
            throw new ExcepcionServiciosBanco("No se pudo consultar el usuario "+correo,ex);
        }
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Iniciativa consultarIniciativa (int id) throws ExcepcionServiciosBanco{
        try{
            return daoIniciativa.consultarIniciativa(id);
        }catch(PersistenceException ex){
            throw new ExcepcionServiciosBanco("No se pudo consultar la iniciativa "+id,ex);
        }
    } 
     @Override
    public List<Iniciativa> consultarIniciativas() throws ExcepcionServiciosBanco {
        try {
            return daoIniciativa.consultarIniciativas();
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosBanco("No hay Iniciativas ", ex);
        }
    }
    @Override
    public void registrarIniciativa(Iniciativa in) throws ExcepcionServiciosBanco{
        try{
            daoIniciativa.registrarIniciativa(in);
            ArrayList<String> palabras = (ArrayList<String>) in.getPalabras();
            daoIniciativa.registrarPalabrasClave(in.getId(),palabras);
        }catch (PersistenceException ex){
            throw new ExcepcionServiciosBanco("no se pudo registrar ",ex);
        }
    }
          
    @Override
    public  List<Iniciativa> consultarIniciativas(ArrayList<String> palabrasclave)throws ExcepcionServiciosBanco{
        try{
            return daoIniciativa.consultarIniciativas(palabrasclave);
        }
        catch(PersistenceException ex){
            throw new ExcepcionServiciosBanco("Error al consultar las iniciativas con las palabras clave"+palabrasclave,ex);
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
    public void UpdateEstado (int id,String estado) throws ExcepcionServiciosBanco {
        try{
            daoIniciativa.UpdateEstado(id,estado);
        }catch (PersistenceException ex){
            throw new ExcepcionServiciosBanco("no se pudo actualizar DAO ",ex);
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

    @Override
    public void registrarLike(int id, String correo) throws ExcepcionServiciosBanco {
        try{
            daoLike.registrarLikes(id,correo);

        }catch(PersistenceException ex){
            throw new ExcepcionServiciosBanco("No se pudo registrar like ",ex);
        }

    }

    @Override
    public List<Like> consultarLikesIn (int id) throws ExcepcionServiciosBanco{
        try {
            return daoLike.consultarLikesIn(id);
        } catch (PersistenceException e) {
            throw new ExcepcionServiciosBanco("No se pudo consultar likes " + id,e);
        }
    }

    @Override
    public Like consultarLikesInCor(int id, String corr) throws ExcepcionServiciosBanco {
        try {
            return daoLike.consultarLikesInCor(id,corr);
        } catch (PersistenceException e) {
            throw new ExcepcionServiciosBanco("No se pudo consultar likes por id y usuario " + id,e);
        }
    }

    @Override
    public void deleteLikes(int id, String correo) throws ExcepcionServiciosBanco {
        try {
             daoLike.deleteLikes(id,correo);
        } catch (PersistenceException e) {
            throw new ExcepcionServiciosBanco("No se pudo eliminar likes " + id,e);
        }
    }


}
