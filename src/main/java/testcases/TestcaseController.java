package testcases;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.EntityTransaction;
import app.ApplicationDAO;

@Named
@ViewScoped
public class TestcaseController implements Serializable{

    @Inject
    private ApplicationDAO dao ;

    private int index = 0;
    Testcase testcase;
    
    public int getIndex()
    {
        return index;
    }

    public void setIndex(int id)
    {
        this.index = id; 
    }

    
    public int getMaxIndex()
    {
        return (int) dao.getTestcasesCount() -1 ;
    }
    
    public void setNextIndex() {
        if (testcase == null) {
            this.index = (int) dao.getNextTestcaseId();
            this.testcase = new Testcase();
            this.testcase.setId((long) this.index);
        }
    }

    public Testcase getTestcase()
    {
        if (testcase == null) {
            testcase = dao.getTestcaseAtIndex(index);
        }
        return testcase;
    }

    public String saveCurrent() {
        Testcase current = getTestcase();
        if (current == null) {
            return "testcases";
        }
        dao.merge(current);
        dao.getAllTestcases();
        return "testcases";
    }
 
    public void next() {
        System.err.println("Saving testcase " + testcase.getId());
        EntityTransaction t = dao.getAndBeginTransaction();
        dao.merge(testcase);
        t.commit();
        if (index > 0) {
            index++;
        }
        testcase = null;
    }

    public void previous() {
        System.err.println("Saving Testcase " + testcase.getId());
        EntityTransaction t = dao.getAndBeginTransaction();
        dao.merge(testcase);
        t.commit();
        if (index > 0) {
            index--;
        }        
        testcase = null;
    }

    public String addTestcase() {
        if (testcase == null) {
            testcase = new Testcase();
        }
        if (testcase.getId() == null) {
            testcase.setId((long) index);
        }
        dao.persist(testcase);
        return "testcases";
    }

    public void removeTestcase() {
        if(dao.getTestcasesCount()>0)
            dao.removeTestcase(testcase);
    }


    public List<Testcase> getAllTestcases() {
        return dao.getAllTestcases();
    }

}
