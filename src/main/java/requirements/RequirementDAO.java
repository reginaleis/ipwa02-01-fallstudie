package requirements;

import jakarta.persistence.*;
import java.util.List;

public class RequirementDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("RequirementPU");

    public List<Requirement> getAll() {
        EntityManager em = emf.createEntityManager();
        List<Requirement> list = em.createQuery("SELECT r FROM Requirements r", Requirement.class).getResultList();
        em.close();
        return list;
    }

    public Requirement getById(Long id) {
        EntityManager em = emf.createEntityManager();
        Requirement r = em.find(Requirement.class, id);
        em.close();
        return r;
    }

    public void save(Requirement r) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        if (r.getId() == null) em.persist(r); else em.merge(r);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Requirement r = em.find(Requirement.class, id);
        if (r != null) em.remove(r);
        em.getTransaction().commit();
        em.close();
    }
}
