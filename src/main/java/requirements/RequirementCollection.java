package requirements;

import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class RequirementCollection
{
    private final List<Requirement> requirements = new ArrayList<>();

    /**
     * Creates a new instance of RequirementOverview
     */
    public RequirementCollection()
    {
        requirements.add(new Requirement(1, "Autor 1", "Inhalt 1", new ArrayList<>(), "Draft", "Functional"));
        requirements.add(new Requirement(2, "Autor 2", "Inhalt 2", new ArrayList<>(), "Approved", "Non-Functional"));
    }

    public List<Requirement> getRequirements()
    {
        return requirements;
    }
}