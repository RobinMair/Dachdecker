package facades;

import entities.Auftrag;
import entities.Mitarbeiter;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.LinkedList;
import java.util.List;

@Stateless
public class MitarbeiterFacade {
    @PersistenceContext
    EntityManager entityManager;

    public void save(Mitarbeiter mitarbeiter){
        entityManager.persist(mitarbeiter);
    }

    public void delete(Mitarbeiter mitarbeiter){
        entityManager.remove(entityManager.find(Mitarbeiter.class, mitarbeiter.getId()));
    }

    public void update(Mitarbeiter mitarbeiter){
        Mitarbeiter old;
        old = entityManager.find(Mitarbeiter.class, mitarbeiter.getId());
        old.setBeschaeftigt(!mitarbeiter.getBeschaeftigt());
        entityManager.merge(old);
    }

    public List<Mitarbeiter> getAllEmployees(){
        List<Mitarbeiter> employees = new LinkedList<>();
        Query q = entityManager.createNamedQuery("getAllEmployees");
        employees = q.getResultList();
        return employees;
    }
}
