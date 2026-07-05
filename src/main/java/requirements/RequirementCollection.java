package requirements;

import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class RequirementCollection
{
    private RequirementDAO dao = new RequirementDAO();
    private final List<Requirement> requirements;

    @PostContruct
    public void init() {
        requirements = dao.getAll();
    }

    public void removeRequirement(Requirement r) {
        dao.delete(r.getId());
        requirements = dao.getAll();
    }

}