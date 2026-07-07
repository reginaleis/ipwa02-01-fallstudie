package requirements;

import java.util.List;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Named
@ApplicationScoped
public class RequirementDAO {
    EntityManagerFactory entityManagerFactory;

    @PostConstruct
    void init() {
        entityManagerFactory = Persistence.createEntityManagerFactory("require4testing");
    }

    public List<Requirement> getAll() {
        EntityManager em = entityManagerFactory.createEntityManager();
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Requirement> cq = cb.createQuery(Requirement.class);
            Root<Requirement> root = cq.from(Requirement.class);
            cq.select(root).orderBy(cb.asc(root.get("id")));
            return em.createQuery(cq).getResultList();
        } finally {
            em.close();
    }
    }

    public long getRequirementsCount() {
        EntityManager em = entityManagerFactory.createEntityManager();
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Long> cq = cb.createQuery(Long.class);
            cq.select(cb.count(cq.from(Requirement.class)));
            return em.createQuery(cq).getSingleResult();
        } finally {
            em.close();
    }}

    public Requirement getRequirementAtIndex(int pos) {
        EntityManager em = entityManagerFactory.createEntityManager();
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Requirement> cq = cb.createQuery(Requirement.class);
            Root<Requirement> root = cq.from(Requirement.class);
            cq.select(root).orderBy(cb.asc(root.get("id")));
            return em.createQuery(cq)
                .setFirstResult(pos)
                .setMaxResults(1)
                .getSingleResult();
        } finally {
            em.close();
    }}

    public EntityTransaction getAndBeginTransaction() {
        EntityManager em = entityManagerFactory.createEntityManager();
        try {
            EntityTransaction tran = em.getTransaction();
            tran.begin();
            return tran;
        } finally {
            em.close();
        }
    }

    public void merge(Requirement req) {
        EntityManager em = entityManagerFactory.createEntityManager();
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
        } finally {
            em.close();
        }
    }
    public void persist(Requirement req) {
        EntityManager em = entityManagerFactory.createEntityManager();
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
        } finally {
            em.close();
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
