package testcases;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Named
@ApplicationScoped
public class TestcaseDAO {

    EntityManager em;

    CriteriaBuilder cb;

    public TestcaseDAO() {
        em = Persistence.createEntityManagerFactory("require4testing").createEntityManager();
        cb = em.getCriteriaBuilder();
    }

    public List<Testcase> getAll() {
        
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
        for (Testcase testcase : getAll()) {
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

    public EntityTransaction getAndBeginTransaction() {
        EntityTransaction tran = em.getTransaction();
        tran.begin();
        return tran;
    }

    public void merge(Testcase req) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(req);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;
        } 
    }


    public void persist(Testcase req) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(req);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;
        }
    }

    public void addTestcase(Testcase req) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(req);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;
        }
    }

    public void removeTestcase(Testcase req) {
        // TODO: use createCriteriaDelete
    }

    public static void main(String[] args) {
        TestcaseDAO dao = new TestcaseDAO();
        System.err.println("Wir haben " + dao.getTestcasesCount() + " Testcases.");
    }

}
