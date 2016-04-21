/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.inject.Named;

import java.io.Serializable;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.sql.Area;
import modelo.sql.Profesor;
import modelo.sql.Tipo;


/**
 *
 * @author Rodrigo
 */
@Named(value = "actividadBean")
@ViewScoped
@ManagedBean
public class NuevaActibidadBean implements Serializable {
    
    /// atributos iguales alos del los pojos
    private int idActividad;
     private Area area;
     private Profesor profesor;
     private Tipo tipo;
     private int ICupodisponible;
     private int ICupomaximo;
     private String SNombre;
     private String SDescripciom;
     private Date FFechamodificacion;
     private Date FFechadescripion;
     
     
    public NuevaActibidadBean() {
        
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public void setICupodisponible(int ICupodisponible) {
        this.ICupodisponible = ICupodisponible;
    }

    public void setICupomaximo(int ICupomaximo) {
        this.ICupomaximo = ICupomaximo;
    }

    public void setSNombre(String SNombre) {
        this.SNombre = SNombre;
    }

    public void setSDescripciom(String SDescripciom) {
        this.SDescripciom = SDescripciom;
    }

    public void setFFechamodificacion(Date FFechamodificacion) {
        this.FFechamodificacion = FFechamodificacion;
    }

    public void setFFechadescripion(Date FFechadescripion) {
        this.FFechadescripion = FFechadescripion;
    }
    
    public void guardarActividad (){
    modelo.dao.ActividadDao.introducirActividad(idActividad, profesor, tipo, ICupodisponible, ICupomaximo, SNombre, SDescripciom, FFechamodificacion, FFechadescripion);
    }

    public int getIdActividad() {
        return idActividad;
    }

    public Area getArea() {
        return area;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public int getICupodisponible() {
        return ICupodisponible;
    }

    public int getICupomaximo() {
        return ICupomaximo;
    }

    public String getSNombre() {
        return SNombre;
    }

    public String getSDescripciom() {
        return SDescripciom;
    }

    public Date getFFechamodificacion() {
        return FFechamodificacion;
    }

    public Date getFFechadescripion() {
        return FFechadescripion;
    }
    
    
}
