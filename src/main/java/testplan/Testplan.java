package testplan;
import java.util.List;
import java.time.LocalDateTime;
import java.time.Duration;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped

public class Testplan {
    
    private Long id;
    private String user;
    private LocalDateTime startTime;
    private String testbench;
    private Duration estimatedDuration;
    private String result;

    public Testplan(int id, String user, LocalDateTime startTime, String testbench, Duration estimatedDuration, String result)
    {
        this.id = (long) id;
        this.user = user;
        this.startTime = startTime;
        this.testbench = testbench;
        this.estimatedDuration = estimatedDuration;
        this.result = result;
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


}
