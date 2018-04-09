package facades;

import entities.Baumaterial;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.LinkedList;
import java.util.List;

@Stateless
public class BaumaterialFacade {
    @PersistenceContext
    EntityManager entityManager;

    public void save(Baumaterial baumaterial){
        entityManager.persist(baumaterial);
    }

    public List<Baumaterial> getAllBM(){
        List<Baumaterial> baumaterials = new LinkedList<>();
        Query q = entityManager.createNamedQuery("getAllBMs");
        baumaterials = q.getResultList();
        return baumaterials;
    }
}
