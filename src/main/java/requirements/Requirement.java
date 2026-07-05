package requirements;
import java.util.List;
import javax.persistence.*;

import java.io.Serializable;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
@Entity
@Table(name="Requirements")
public class Requirement implements Serializable
{   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment
    private Long id;

    private String author;

    private String content;

    private List<String> linkedTestcases;

    private String status;
    
    private String type;

    public Requirement(int id, String author, String content, List<String> linkedTestcases, String status, String type)
    {
        this.id = (long) id;
        this.author = author;
        this.content = content;
        this.linkedTestcases = linkedTestcases;
        this.status = status;
        this.type = type;
    }

    public Long getId()
    {
        return id;
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

    public List<String> getLinkedTestcases()
    {
        return linkedTestcases;
    }

    public void setLinkedTestcases(List<String> linkedTestcases)
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