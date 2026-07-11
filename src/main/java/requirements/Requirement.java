package requirements;
import testcases.Testcase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Comparator;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Requirements")
public class Requirement implements Serializable
{   
    @Id
    private Long id;

    private String author; // TODO: link to User entity

    private String content;

    @OneToMany(mappedBy = "testedRequirement")
    private Set<Testcase> linkedTestcases;

    private String status; // TODO: change to enum
    
    private String type; // TODO: change to enum

    public Requirement() {

    }

    public Requirement(int id, String author, String content, String status, String type)
    {
        this.id = (long) id;
        this.author = author;
        this.content = content;
        this.linkedTestcases = new HashSet<>();
        this.status = status;
        this.type = type;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public Set<Testcase> getLinkedTestcases()
    {
        return linkedTestcases;
    }

    public List<Testcase> getLinkedTestcasesSorted()
    {
        List<Testcase> sortedLinkedTestcases = new ArrayList<>();
        if (linkedTestcases != null) {
            sortedLinkedTestcases.addAll(linkedTestcases);
            sortedLinkedTestcases.sort(Comparator.comparing(Testcase::getId, Comparator.nullsLast(Comparator.naturalOrder())));
        }
        return sortedLinkedTestcases;
    }

    public void setLinkedTestcases(Set<Testcase> linkedTestcases)
    {
        this.linkedTestcases = linkedTestcases;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

}