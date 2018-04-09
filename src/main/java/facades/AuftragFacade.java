package facades;

import entities.Auftrag;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.Registration;
import java.util.LinkedList;
import java.util.List;

@Stateless
public class AuftragFacade {
    @PersistenceContext
    EntityManager entityManager;

    public void save(Auftrag auftrag){
        entityManager.persist(auftrag);
    }

    public void update(Auftrag auftrag){
        Auftrag old;
        old = entityManager.find(Auftrag.class, auftrag.getId());
        old.setAuftragsstatus(auftrag.getAuftragsstatus());
        entityManager.merge(old);
    }


    public List<Auftrag> getAllAssignments(){
        List<Auftrag> kunden = new LinkedList<>();
        Query q = entityManager.createNamedQuery("getAllAssignments");
        kunden = q.getResultList();
        return kunden;
    }
}
