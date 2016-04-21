/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.util.List;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import modelo.dao.ActividadDao;
import modelo.sql.Actividad;

/**
 *
 * @author luis
 */
@Named(value = "mostrarActividadesBean")
@Dependent
public class MostrarActividadesBean {

    /**
     * Creates a new instance of MostrarActividadesBean
     */
    Actividad actividad;
    List<Actividad> actividades;
    
    public MostrarActividadesBean() {
        actividad = new Actividad();
    }
    
    public List<Actividad> getActividades(){
        ActividadDao linkDao = new ActividadDao();
        actividades = linkDao.getAll();
        return actividades;
    }
    
}
