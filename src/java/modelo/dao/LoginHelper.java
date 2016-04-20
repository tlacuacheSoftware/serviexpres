/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import modelo.sql.Alumno;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Rodrigo
 */
public class LoginHelper {

    private Session session;

    public LoginHelper() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public Alumno getLoginPorNombre(String nombre) {
        Alumno usuario;
        try {
            Transaction tx = session.beginTransaction();
            Query q = session.getNamedQuery("BuscarPorNombre").setString("s_nombre", nombre);
            return (Alumno) q.uniqueResult();
        } catch (Exception e) {
        }
        return null;

    }

}
