package requirements;

import java.util.List;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class RequirementCollection
{
    @Inject
    private RequirementDAO dao;

    private List<Requirement> requirements;

    @PostConstruct
    public void init() {
        refresh();
    }
    
    public void refresh() {
        requirements = dao.getAll();
    }

    public List<Requirement> getRequirements()
    {
        return requirements;
    }

}