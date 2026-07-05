package requirements;

import java.io.Serializable;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ViewScoped
public class RequirementController implements Serializable{

    @Inject
    RequirementCollection requirementCollection;

    private int index = 0;

    public Requirement getRequirement()
    {
        return requirementCollection.getRequirements().get(index);
    }
 
    public void next()
    {
        if (index < requirementCollection.getRequirements().size() -1) {
            index++;
        }
    }

    public void previous() {
        if (index > 0) {
            index--;
        }
    }
    
    public int getIndex()
    {
        return index;
    }

    public int getMaxIndex()
    {
        return requirementCollection.getRequirements().size()-1;
    }


}
