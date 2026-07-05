package app;

import java.io.Serializable;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

@Named("navigationBean")
@RequestScoped
public class NavigationBean implements Serializable {

    public String getCurrentPage() {
        String viewId = FacesContext.getCurrentInstance().getViewRoot().getViewId();
        return viewId.substring(viewId.lastIndexOf('/') + 1);
    }

    public boolean active(String pageName) {
        return getCurrentPage().equals(pageName);
    }
}