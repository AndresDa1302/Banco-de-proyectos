/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.persistence.mybatisimpl.mappers;

import edu.eci.cvds.samples.entities.Iniciativa;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author Jairo Gomez
 */
public interface IniciativaMapper {
    public Iniciativa consultarIniciativa(@Param("idin") int id);
    public List<Iniciativa> consultarIniciativas();
}