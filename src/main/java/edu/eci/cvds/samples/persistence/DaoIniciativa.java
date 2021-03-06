/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.persistence;

import edu.eci.cvds.samples.entities.Area;
import edu.eci.cvds.samples.entities.Iniciativa;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel Gomez
 */
public interface DaoIniciativa {

    /**
     *
     * @param id
     * @return
     * @throws edu.eci.cvds.samples.persistence.PersistenceException
     */
    public Iniciativa consultarIniciativa(int id) throws PersistenceException;
    public List<Iniciativa> consultarIniciativas() throws PersistenceException;
    public void registrarIniciativa(Iniciativa in) throws  PersistenceException;
    public void UpdateEstado(int id,String estado) throws  PersistenceException;
    public List<Iniciativa> consultarIniciativas(ArrayList<String> palabrasclave) throws PersistenceException;
    public void registrarPalabrasClave(int id, ArrayList<String> palabras)throws PersistenceException;
    


    public List<Area> iniciativasPorArea() throws PersistenceException;
    
    public List<Iniciativa> iniciativasPorEstado(String estado)throws PersistenceException; 

    public List<Iniciativa>  consultarIniciativaCor(String cor) throws PersistenceException;

    public void updateDescripcion(String des, int id) throws PersistenceException;
    
    public void agruparIniciativa(Iniciativa iniciativa,int idGrupo) throws PersistenceException;
    
    public int selectid() throws PersistenceException;
    
    public List<Iniciativa> consultarRelacionados(Iniciativa iniciativa) throws PersistenceException;
    
}
