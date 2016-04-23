package beans;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import modelo.dao.ActividadDao;
import modelo.dao.ProfesorDao;
import modelo.sql.Actividad;
import modelo.sql.Profesor;


@ManagedBean
@RequestScoped
public class BuscarProfesor {

    private Actividad actividad;
    private LinkedList<Actividad> actividades;
    private String profesor;
    private LinkedList<Profesor> profesores;
    private String criterio;
    private final ProfesorDao helperProfesor;
    private final ActividadDao helperActividad;
    private final HttpServletRequest httpServletRequest;
    private final FacesContext faceContext;
    private FacesMessage message;

    public BuscarProfesor() {
        faceContext = FacesContext.getCurrentInstance();
        httpServletRequest = (HttpServletRequest) faceContext.getExternalContext().getRequest();
        helperProfesor = new ProfesorDao();
        helperActividad = new ActividadDao();
        profesor = "asdfewrgf";
        actividad = new Actividad();
    }

    public void obtenerActividades(){
        //actividades = new LinkedList<>(helperActividad.getByProfID(profesor.getIdProfesor()));
    }
    
    public void obtenerProfesores(){
        List<Profesor> l;
        int i;
        String s = "FROM Profesor WHERE s_nombre = '" + criterio + 
                "' OR s_appaterno = '" + criterio + "' OR s_apmaterno = '" + criterio + "'";
        l = helperProfesor.getByNameAppApm(s);
        if(l == null){
            profesores = new LinkedList<>();
        }else{
            profesores = new LinkedList<>(l);
        }
    }
    
    public String buscarActividades(){
        //obtenerActividades();
        return "actividades";
        /*if(actividades == null){
            return "mostrar";
        }else if(actividades.isEmpty()){
            return "mostrar";
        }else{
            return "actividades";
        }*/
    }
    
    public String buscarProfesores(){
        obtenerProfesores();
        if(profesores == null){
            return "buscar";
        }else if(profesores.isEmpty()){
            return "buscar";
        }else{
            return "mostrar";
        }
    }

    public String getCriterio() {
        return criterio;
    }

    public void setCriterio(String criterio) {
        this.criterio = criterio;
    }

    public LinkedList<Profesor> getProfesores() {
        return profesores;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public LinkedList<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(LinkedList<Actividad> actividades) {
        this.actividades = actividades;
    }

    
}