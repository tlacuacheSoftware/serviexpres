/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.util.List;
import modelo.sql.Area;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author esmeralda
 */
public class AreaDao {
    
    private Session session;
    private Transaction tx;
    private Integer idArea;
    
    private void init(){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        tx = session.beginTransaction();
    }
            
    private void rollback(){
        if(tx != null){
            tx.rollback();
        }
    }
    
    public List<Area> getAll(){
        List<Area> list = null;
        try{
            init();
            String s = "from Area";
            Query query = session.createQuery(s);
            list = query.list();
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    
    public boolean update(Area obj){
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
    
    public Integer insert(Area obj){
        Integer b = -1;
        try{
            init();
            idArea = (Integer) session.save(obj);
            tx.commit();
            b = idArea;
        }catch(Exception e){
            rollback();
        
            
        }
        return b;
    }
    
    public boolean delete(Area obj){
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
