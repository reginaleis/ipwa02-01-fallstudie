package requirements;

import app.ApplicationDAO;

import jakarta.enterprise.inject.spi.CDI;
import jakarta.faces.convert.Converter;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.FacesConverter;
import jakarta.faces.component.UIComponent;

@FacesConverter(value = "requirementConverter", managed = true)
public class RequirementConverter implements Converter<Requirement> {
    private ApplicationDAO getDao() {
        return CDI.current().select(ApplicationDAO.class).get();
    }

    @Override
    public Requirement getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isBlank()) {
            return null;
        }
        Long id = Long.valueOf(value);
        return getDao().getRequirementById(id);
    }
    
    @Override
    public String getAsString(FacesContext context, UIComponent component, Requirement value) {
       if (value == null || value.getId() == null) {
            return "";
        }
        return value.getId().toString();
    }
}
