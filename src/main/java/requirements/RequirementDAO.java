package requirements;

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
public class RequirementDAO {

    EntityManager em;

    CriteriaBuilder cb;

    public RequirementDAO() {
        em = Persistence.createEntityManagerFactory("require4testing").createEntityManager();
        cb = em.getCriteriaBuilder();
    }

    public List<Requirement> getAll() {
        
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

    public Requirement getRequirementAtIndex(int pos) {
        
        CriteriaQuery<Requirement> cq = cb.createQuery(Requirement.class);
        Root<Requirement> root = cq.from(Requirement.class);
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

    public void merge(Requirement req) {
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


    public void persist(Requirement req) {
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

    public void removeRequirement(Requirement req) {
        // TODO: use createCriteriaDelete
    }

    public static void main(String[] args) {
        RequirementDAO dao = new RequirementDAO();
        System.err.println("Wir haben " + dao.getRequirementsCount() + " Requirements.");
    }

}
