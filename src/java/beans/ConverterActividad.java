
package beans;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import modelo.dao.ActividadDao;
import modelo.sql.Actividad;

@FacesConverter(forClass = SolicitarModalidad.class)
public class ConverterActividad implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
            if(value!=null && value.trim().length()>0){
                int id = Integer.valueOf(value);
                ActividadDao dao = new ActividadDao();
                return dao.getByID(id);
            }
            return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        /*if(value!=null && value instanceof Actividad){
            Actividad prof = (Actividad) value;
            return "" + prof.getIdActividad();
        }
        return null;*/
        return value.toString();
    }
    
}
