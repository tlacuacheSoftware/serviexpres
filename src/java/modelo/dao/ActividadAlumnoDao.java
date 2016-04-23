/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.util.List;
import modelo.sql.ActividadAlumno;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author esmeralda
 */
public class ActividadAlumnoDao {
    
    private Session session;
    private Transaction tx;
    private Integer idActividadAlumno;
    
    private void init(){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        tx = session.beginTransaction();
    }
            
    private void rollback(){
        if(tx != null){
            tx.rollback();
        }
    }
    
    public List<ActividadAlumno> getAll(){
        List<ActividadAlumno> list = null;
        try{
            init();
            String s = "from ActividadAlumno";
            Query query = session.createQuery(s);
            list = query.list();
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    
    public boolean update(ActividadAlumno obj){
        boolean b = false;
        try{
            init();
            session.update(obj);
            tx.commit();
            b = true;
        }catch(Exception e){
            rollback();
        
            
        }
        return b;
    }
    
    public Integer insert(ActividadAlumno obj){
        Integer b = -1;
        try{
            init();
            idActividadAlumno = (Integer) session.save(obj);
            tx.commit();
            b = idActividadAlumno;
        }catch(Exception e){
            rollback();
        
            
        }
        return b;
    }
    
    public boolean delete(ActividadAlumno obj){
        boolean b = false;
        try{
            init();
            session.delete(obj);
            tx.commit();
            b = true;
        }catch(Exception e){
            rollback();
        
            
        }
        return b;
    }
}
