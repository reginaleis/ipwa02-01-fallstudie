package testplan;
import testcases.Testcase;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="Testplans")
public class Testplan {
    
    @Id
    private Long id;
    private String user;
    private LocalDateTime startTime;
    private String testbench;
    private Duration estimatedDuration;
    private String result;
    @OneToMany
    @JoinTable(
        name = "Testplans_Testcases",
        joinColumns = @JoinColumn(name = "testplan_id"),
        inverseJoinColumns = @JoinColumn(name = "testcase_id"))
    private Set<Testcase> testcases; // TODO : use a TestSuite here instead

    public Testplan(int id, String user, LocalDateTime startTime, String testbench, Duration estimatedDuration, String result)
    {
        this.id = (long) id;
        this.user = user;
        this.startTime = startTime;
        this.testbench = testbench;
        this.estimatedDuration = estimatedDuration;
        this.result = result;
        this.testcases = new HashSet<>();
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getUser()
    {
        return user;
    }

    public void setUser(String user)
    {
        this.user = user;
    }

    public LocalDateTime getStartTime()
    {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime)
    {
        this.startTime = startTime;
    }


    public String getTestbench()
    {
        return testbench;
    }

    public void setTestbench(String testbench)
    {
        this.testbench = testbench;
    }

    public Duration getEstimatedDuration()
    {
        return estimatedDuration;
    }

    public void setEstimatedDuration(Duration estimatedDuration)
    {
        this.estimatedDuration = estimatedDuration;
    }

    public String getResult()
    {
        return result;
    }

    public void setResult(String result)
    {
        this.result = result;
    }

    public Set<Testcase> getTestcases()
    {
        return testcases;
    }

    public void setTestcases(Set<Testcase> testcases)
    {
        this.testcases = testcases;
    }
}
