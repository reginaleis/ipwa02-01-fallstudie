package beans;
import java.util.List;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped

public class Testcase {
    
    private Long id;
    private String tester;
    private String description;
    private List<String> testSteps;
    private String expectedResult;
    private String lastTestResult;
    private List<String> testedRequirements;

    public Testcase(int id, String tester, String description, List<String> testSteps, String expectedResult, String lastTestResult)
    {
        this.id = (long) id;
        this.tester = tester;
        this.description = description;
        this.testSteps = testSteps;
        this.expectedResult = expectedResult;
        this.lastTestResult = lastTestResult;
        this.testedRequirements = null;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getTester()
    {
        return tester;
    }

    public void setTester(String tester)
    {
        this.tester = tester;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public List<String> getTestSteps()
    {
        return testSteps;
    }

    public void setTestSteps(List<String> testSteps)
    {
        this.testSteps = testSteps;
    }

    public String getExpectedResult()
    {
        return expectedResult;
    }

    public void setExpectedResult(String expectedResult)
    {
        this.expectedResult = expectedResult;
    }

    public String getLastTestResult()
    {
        return lastTestResult;
    }

    public void setLastTestResult(String lastTestResult)
    {
        this.lastTestResult = lastTestResult;
    }

    public List<String> getTestedRequirements()
    {
        return testedRequirements;
    }

    public void setTestedRequirements(List<String> testedRequirements)
    {
        this.testedRequirements = testedRequirements;
    }

}
