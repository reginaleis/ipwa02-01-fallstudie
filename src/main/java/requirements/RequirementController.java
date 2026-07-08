package requirements;

import java.io.Serializable;
import java.util.List;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.EntityTransaction;

@Named
@ViewScoped
public class RequirementController implements Serializable{

    @Inject
    private RequirementDAO dao ;

    private int index = 0;
    Requirement requirement;
    
    public int getIndex()
    {
        return index;
    }

    public void setIndex(int id)
    {
        this.index = id; 
    }

    
    public int getMaxIndex()
    {
        return (int) dao.getRequirementsCount() -1 ;
    }
    
    public void setNextIndex() {
        if (requirement == null) {
            this.index = (int) dao.getNextRequirementId();
            this.requirement = new Requirement();
            this.requirement.setId((long) this.index);
        }
    }

    public Requirement getRequirement()
    {
        if (requirement == null) {
            requirement = dao.getRequirementAtIndex(index);
        }
        return requirement;
    }

    public String saveCurrent() {
        Requirement current = getRequirement();
        if (current == null) {
            return "requirements";
        }
        dao.merge(current);
        dao.getAll();
        return "requirements";
    }
 
    public void next() {
        System.err.println("Saving Requirement " + requirement.getId());
        EntityTransaction t = dao.getAndBeginTransaction();
        dao.merge(requirement);
        t.commit();
        if (index > 0) {
            index++;
        }
        requirement = null;
    }

    public void previous() {
        System.err.println("Saving Requirement " + requirement.getId());
        EntityTransaction t = dao.getAndBeginTransaction();
        dao.merge(requirement);
        t.commit();
        if (index > 0) {
            index--;
        }        
        requirement = null;
    }

    public String addRequirement() {
        if (requirement == null) {
            requirement = new Requirement();
        }
        if (requirement.getId() == null) {
            requirement.setId((long) index);
        }
        dao.addRequirement(requirement);
        return "requirements";
    }

    public void removeRequirement() {
        if(dao.getRequirementsCount()>0)
            dao.removeRequirement(requirement);
    }


    public List<Requirement> getAllRequirements() {
        return dao.getAll();
    }

}
