/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import modelo.sql.Actividad;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Rodrigo
 */
public class ActividadDao {
    
    Session session ;
    Transaction tx;
    Integer idActividad;
    
    private void init(){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        tx = session.beginTransaction();
    }
    
    private void rollback(){
    if(tx != null){
        tx.rollback();
    
    }
    
    }
    
   public Integer insert(Actividad obj){
        Integer b = -1;
        try{
            init();
            idActividad = (Integer) session.save(obj);
            tx.commit();
            b = idActividad;
        }catch(Exception e){
            rollback();
        
            
        }
        return b;
    }
    
}
