package beans;
import java.util.List;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class Requirement
{
    private Long id;
    private String author;
    private String content;
    private List<String> linkedTestcases;
    private String status;
    private String type;

    public Requirement(int id, String author, String content, List<String> linked_testcases, String status, String type)
    {
        this.id = (long) id;
        this.author = author;
        this.content = content;
        this.linked_testcases = linked_testcases;
        this.status = status;
        this.type = type;
    }
    {
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

    public List<String> getLinked_testcases()
    {
        return linked_testcases;
    }

    public void setLinked_testcases(List<String> linked_testcases)
    {
        this.linked_testcases = linked_testcases;
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