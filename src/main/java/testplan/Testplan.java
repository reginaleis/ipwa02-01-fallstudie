package testplan;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import testcases.Testcase;


@Entity
@Table(name="Testplans")
public class Testplan {
    
    @Id
    private Long id;

    private LocalDateTime plannedDate;

    @OneToOne
    @JoinColumn(name = "testcase_id", unique=true)
    private Testcase testcase; // TODO : use a TestSuite or List of Testcases here instead

    public Testplan(){}

    public Testplan(int id, LocalDateTime plannedDate, Testcase testcase)
    {
        this.id = (long) id;
        this.plannedDate = plannedDate;
        this.testcase = testcase;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public LocalDateTime getPlannedDate()
    {
        return plannedDate;
    }

    public void setPlannedDate(LocalDateTime plannedDate)
    {
        this.plannedDate = plannedDate;
    }

    public Testcase getTestcase()
    {
        return testcase;
    }

    public void setTestcase(Testcase testcase)
    {
        this.testcase = testcase;
    }
}
