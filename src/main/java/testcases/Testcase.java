package testcases;
import java.util.List;
import java.util.Set;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import requirements.Requirement;


@Entity
@Table(name="Testcases") 
public class Testcase {
    
    @Id
    private Long id;

    private String tester; // TODO: link to User entity

    private String description;

    private String testSteps; // TODO: change to List<String> and convert for persistence

    private String expectedResult; // TODO: change to List<String> and convert for persistence

    private String lastTestResult; // TODO: change to enum

    @ManyToOne
    @JoinTable(
        name = "Requirements_Testcases",
        joinColumns = @JoinColumn(name = "testcase_id"),
        inverseJoinColumns = @JoinColumn(name = "requirement_id"))
    private Requirement testedRequirement;

    private Date nextExecutionDate; // TODO: Auto set this from Testplan

    public Testcase() {

    }

    public Testcase(int id, String tester, String description, String testSteps, String expectedResult, String lastTestResult, Requirement testedRequirement)
    {
        this.id = (long) id;
        this.tester = tester;
        this.description = description;
        this.testSteps = testSteps;
        this.expectedResult = expectedResult;
        this.lastTestResult = lastTestResult;
        this.testedRequirement = testedRequirement;
        this.nextExecutionDate = new Date(0);
    }


    public Testcase(int id, String tester, String description, String testSteps, String expectedResult, String lastTestResult, Requirement testedRequirement, Date nextExecutionDate)
    {
        this.id = (long) id;
        this.tester = tester;
        this.description = description;
        this.testSteps = testSteps;
        this.expectedResult = expectedResult;
        this.lastTestResult = lastTestResult;
        this.testedRequirement = testedRequirement;
        this.nextExecutionDate = nextExecutionDate;
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

    public Requirement getTestedRequirement()
    {
        return testedRequirement;
    }

    public void setTestedRequirement(Requirement testedRequirement)
    {
        this.testedRequirement = testedRequirement;
    }

    public Date getNextExecutionDate()
    {
        return nextExecutionDate;
    }

    public void setNextExecutionDate(Date nextExecutionDate)
    {
        this.nextExecutionDate = nextExecutionDate;
    }

}
