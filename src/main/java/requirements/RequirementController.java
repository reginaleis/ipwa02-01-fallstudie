package requirements;

import java.io.Serializable;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ViewScoped
public class RequirementController implements Serializable{

    @Inject
    private RequirementDAO dao ;

    @Inject
    private RequirementCollection requirementCollection;

    private int index = 0;
    Requirement requirement;
    
    public int getIndex()
    {
        return index;
    }

    public void setIndex(int id)
    {
        this.index = id -1; 
    }

    public Requirement getRequirement()
    {
        if (requirement == null && !requirementCollection.getRequirements().isEmpty()) {
            requirement = requirementCollection.getRequirements().get(index);
        }
        return requirement;
    }

    public void saveCurrent() {
        Requirement current = getRequirement();
        if (current == null) {
            return;
        }
        dao.merge(current);
        requirementCollection.refresh();
    }
 
    public void next() {
        saveCurrent();
        if (index < requirementCollection.getRequirements().size() - 1) {
            index++;
            requirement = requirementCollection.getRequirements().get(index);
        }
    }

    public void previous() {
        saveCurrent();
        if (index > 0) {
            index--;
            requirement = requirementCollection.getRequirements().get(index);
        }
    }
    

    public void removeRequirement() {
        if(dao.getRequirementsCount()>0)
            dao.removeRequirement(requirement);
    }

    public int getMaxIndex()
    {
        return (int) dao.getRequirementsCount();
    }


}
