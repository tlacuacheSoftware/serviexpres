/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.logging.Level;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import modelo.dao.LoginHelper;
import modelo.sql.Alumno;

/**
 *
 * @author Rodrigo
 */
@ManagedBean // permite dar de alta al bean en la aplicacion
@RequestScoped //es disponible a partir del bean
public class login {

    private String usuario; // representa el nombre ususario
    String contrasena; // representa la contraseña de el usuriaop
    HttpServletRequest httpSertvetRequest; // obtine la informacionde las peticiones
    FacesContext faceContext; //obtine la informacion de la clase
    FacesMessage message; // permite el envio de mensjae etnre el bena y la vista
    LoginHelper helper; //definir una clas

    public login() {
        faceContext = FacesContext.getCurrentInstance();
        httpSertvetRequest = (HttpServletRequest) faceContext.getExternalContext().getRequest();
        helper = new LoginHelper();

    }

    public String login() {
        Alumno alumno = helper.getLoginPorNombre(usuario);
        if (alumno != null) {
            try {
                httpSertvetRequest.getSession().setAttribute("sessionAlumno", alumno);
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "acceso correcto ", null);
                faceContext.addMessage(null, message);
                return "acceso";
            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(Alumno.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "usuario ocontraseña invalido", null);
            faceContext.addMessage(null, message);
            return "index";
        }
        return "index";
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

}
