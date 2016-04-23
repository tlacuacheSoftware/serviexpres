/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.util.List;
import modelo.sql.Alumno;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author esmeralda
 */
public class AlumnoDao {
    
    private Session session;
    private Transaction tx;
    private Integer idAlumno;
    
    private void init(){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        tx = session.beginTransaction();
    }
            
    private void rollback(){
        if(tx != null){
            tx.rollback();
        }
    }
    
    public List<Alumno> getAll(){
        List<Alumno> list = null;
        try{
            init();
            String s = "from Alumno";
            Query query = session.createQuery(s);
            list = query.list();
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    
    public boolean update(Alumno obj){
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
    
    public Integer insert(Alumno obj){
        Integer b = -1;
        try{
            init();
            idAlumno = (Integer) session.save(obj);
            tx.commit();
            b = idAlumno;
        }catch(Exception e){
            rollback();
        
            
        }
        return b;
    }
    
    public boolean delete(Alumno obj){
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
