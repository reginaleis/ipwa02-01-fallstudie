package app;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import requirements.Requirement;
import testcases.Testcase;

@Named
@ApplicationScoped
public class ApplicationDAO {

    EntityManager em;

    CriteriaBuilder cb;

    public ApplicationDAO() {
        em = Persistence.createEntityManagerFactory("require4testing").createEntityManager();
        cb = em.getCriteriaBuilder();
    }

    public EntityTransaction getAndBeginTransaction() {
        EntityTransaction tran = em.getTransaction();
        tran.begin();
        return tran;
    }

    public void merge(Object input) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(input);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;
        } 
    }

    public void persist(Object input) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(input);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;
        }
    }

// TESTCASE DAO

    public List<Testcase> getAllTestcases() {
        
        CriteriaQuery<Testcase> cq = cb.createQuery(Testcase.class);
        Root<Testcase> root = cq.from(Testcase.class);
        cq.select(root).orderBy(cb.asc(root.get("id")));
        return em.createQuery(cq).getResultList();
        
    }

    public long getTestcasesCount() {
       
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        cq.select(cb.count(cq.from(Testcase.class)));
        return em.createQuery(cq).getSingleResult();
       }

    public long getNextTestcaseId() {
        long nextId = 1L;
        for (Testcase testcase : getAllTestcases()) {
            if (testcase.getId() != null && testcase.getId() >= nextId) {
                nextId = testcase.getId() + 1;
            }
        }
        return nextId;
    }

    public Testcase getTestcaseAtIndex(int pos) {
        
        CriteriaQuery<Testcase> cq = cb.createQuery(Testcase.class);
        Root<Testcase> root = cq.from(Testcase.class);
        cq.select(root).orderBy(cb.asc(root.get("id")));
        return em.createQuery(cq)
            .setFirstResult(pos)
            .setMaxResults(1)
            .getSingleResult();
        }


    public void removeTestcase(Testcase req) {
        // TODO: use createCriteriaDelete
    }


// REQUIREMENT DAO

    public List<Requirement> getAllRequirements() {
    
    CriteriaQuery<Requirement> cq = cb.createQuery(Requirement.class);
    Root<Requirement> root = cq.from(Requirement.class);
    cq.select(root).orderBy(cb.asc(root.get("id")));
    return em.createQuery(cq).getResultList();
        
    }

    public long getRequirementsCount() {
       
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        cq.select(cb.count(cq.from(Requirement.class)));
        return em.createQuery(cq).getSingleResult();
       }

    public long getNextRequirementId() {
        long nextId = 1L;
        for (Requirement requirement : getAllRequirements()) {
            if (requirement.getId() != null && requirement.getId() >= nextId) {
                nextId = requirement.getId() + 1;
            }
        }
        return nextId;
    }

    public Requirement getRequirementAtIndex(int pos) {
        
        CriteriaQuery<Requirement> cq = cb.createQuery(Requirement.class);
        Root<Requirement> root = cq.from(Requirement.class);
        cq.select(root).orderBy(cb.asc(root.get("id")));
        return em.createQuery(cq)
            .setFirstResult(pos)
            .setMaxResults(1)
            .getSingleResult();
    }

    public Requirement getRequirementById(Long id) {
        return em.find(Requirement.class, id);
    }

    public void removeRequirement(Requirement req) {
        // TODO: use createCriteriaDelete
    }

// Requirements - Testcases Relationshop

    public void linkTestcaseRequirement(Testcase testcase, Requirement requirement) {

    }

// MAIN

    public static void main(String[] args) {
        ApplicationDAO dao = new ApplicationDAO();
        System.err.println("Wir haben " + dao.getTestcasesCount() + " Testcases");
        System.err.println("und " + dao.getRequirementsCount() + " Anforderungen.");
    }

}
