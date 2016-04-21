/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.sql.Actividad;
import modelo.sql.Profesor;
import modelo.sql.Tipo;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.jboss.logging.Logger;


/**
 *
 * @author Rodrigo
 */
public class ActividadDao {
    
      
   public List<Actividad> getListaActividad(){
    List<Actividad> listaActividad = new ArrayList<Actividad>();
    Session session = ConfHibernate.getSessionFactory().getCurrentSession();
       try {
           session.beginTransaction();
           Criteria criteria = session.createCriteria(Actividad.class);
           listaActividad = criteria.list();
           session.getTransaction().commit();
       } catch (Exception e) {
           
       }
       return listaActividad;
   }
   
   public static void introducirActividad(int idActividad ,Profesor id_profesor ,Tipo id_tipo,
                        int cupoDisponible, int cupoMaximo, String nombre, String descripcion
                            ,Date fechaModificacion, Date fechaDescripcion){
       Session session = ConfHibernate.getSessionFactory().getCurrentSession();
       // crea el obeto activdad vacio
       Actividad miActividad = new Actividad();
       //llena todos los campos
       miActividad.setIdActividad(idActividad);
       miActividad.setProfesor(id_profesor);
       miActividad.setTipo(id_tipo);
       miActividad.setICupodisponible(cupoDisponible);
       miActividad.setICupomaximo(cupoMaximo);
       miActividad.setSNombre(nombre);
       miActividad.setSDescripciom(descripcion);
       miActividad.setFFechamodificacion(fechaModificacion);
       miActividad.setFFechamodificacion(fechaModificacion);
       
       try {
           session.beginTransaction();
           session.save(miActividad);
           session.getTransaction().commit();
       } catch (Exception e) {
           
       }
    
   }
    
}
