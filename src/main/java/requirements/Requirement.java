package requirements;
import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Requirements")
public class Requirement implements Serializable
{   
    @Id
    private Long id;

    private String author;

    private String content;

    // private List<String> linkedTestcases;

    private String status;
    
    private String type;

    public Requirement() {

    }

    public Requirement(int id, String author, String content, String status, String type)
    {
        this.id = (long) id;
        this.author = author;
        this.content = content;
        // this.linkedTestcases = linkedTestcases;
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

    // public List<String> getLinkedTestcases()
    // {
    //     return linkedTestcases;
    // }

    // public void setLinkedTestcases(List<String> linkedTestcases)
    // {
    //     this.linkedTestcases = linkedTestcases;
    // }

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