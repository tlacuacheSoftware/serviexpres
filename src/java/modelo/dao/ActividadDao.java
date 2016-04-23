/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.util.List;
import modelo.sql.Actividad;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author esmeralda
 */
public class ActividadDao {
    
    private Session session;
    private Transaction tx;
    private Integer idActividad;
    
    private void init(){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        tx = session.beginTransaction();
    }
            
    private void rollback(){
        if(tx != null){
            tx.rollback();
        }
    }
    
    public List<Actividad> getAll(){
        List<Actividad> list = null;
        try{
            init();
            String s = "from Actividad";
            Query query = session.createQuery(s);
            list = query.list();
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    
    public boolean update(Actividad obj){
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
    
    public boolean delete(Actividad obj){
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

    public List<Actividad> getByProfID(int profesor) {
        List<Actividad> list = null;
        try{
            init();
            String s = "from Actividad WHERE id_profesor = " + profesor;
            Query query = session.createQuery(s);
            list = query.list();
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    
    public List<Actividad> getByID(int id) {
        List<Actividad> list = null;
        try{
            init();
            String s = "from Actividad WHERE id_actividad= " + id;
            Query query = session.createQuery(s);
            list = query.list();
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
