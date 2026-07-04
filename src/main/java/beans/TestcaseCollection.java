package beans;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class TestcaseCollection
{
    private final Collection<Testcase> testcases = new ArrayList<>();

    public TestcaseCollection()
    {
        testcases.add(new Testcase(1, "Tester 1", "Beschreibung 1", new ArrayList<>(), new ArrayList<>(), "passed"));
        testcases.add(new Testcase(2, "Tester 2", "Beschreibung 2", new ArrayList<>(), new ArrayList<>(), "failed"));
    }

    public Collection<Testcase> getTestcases()
    {
        return testcases;
    }
}