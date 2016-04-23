
package beans;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import modelo.dao.ProfesorDao;
import modelo.sql.Profesor;

@FacesConverter(forClass = BuscarProfesor.class)
public class ConverterProfesor implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
            if(value!=null && value.trim().length()>0){
                int id = Integer.valueOf(value);
                ProfesorDao dao = new ProfesorDao();
                return dao.getByID(id);
            }
            return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        /*if(value!=null && value instanceof Profesor){
            Profesor prof = (Profesor) value;
            return "" + prof.getIdProfesor();
        }
        return null;*/
        return value.toString();
    }
    
}
