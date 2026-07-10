package testcases;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="Testcases")
public class Testcase {
    
    @Id
    private Long id;
    private String tester;
    private String description;
    private String testSteps;
    private String expectedResult;
    private String lastTestResult;
    // private String testedRequirements;

    public Testcase() {

    }

    public Testcase(int id, String tester, String description, String testSteps, String expectedResult, String lastTestResult)
    {
        this.id = (long) id;
        this.tester = tester;
        this.description = description;
        this.testSteps = testSteps;
        this.expectedResult = expectedResult;
        this.lastTestResult = lastTestResult;
        // this.testedRequirements = null;
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

    public String getTestSteps()
    {
        return testSteps;
    }

    public void setTestSteps(String testSteps)
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

    // public String getTestedRequirements()
    // {
    //     return testedRequirements;
    // }

    // public void setTestedRequirements(String testedRequirements)
    // {
    //     this.testedRequirements = testedRequirements;
    // }

}
