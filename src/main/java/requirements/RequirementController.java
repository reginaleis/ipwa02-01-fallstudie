package requirements;

import java.io.Serializable;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import requirements.Requirement;
import requirements.RequirementCollection;

@Named
@ViewScoped
public class RequirementController implements Serializable{

    @Inject
    RequirementCollection requirementCollection;

    private int index = 0;

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
    


    public int getMaxIndex()
    {
        return requirementCollection.getRequirements().size()-1;
    }


}
