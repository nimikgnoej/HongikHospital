package Hongik.Hospital.repository;

import Hongik.Hospital.entity.AllReservation;
import Hongik.Hospital.entity.Department;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class AllRepository {
    @PersistenceContext
    private EntityManager em;

    public void save(AllReservation allReservation) {
        em.persist(allReservation);
    }

    public AllReservation findOne(Long all_id) {
        return em.find(AllReservation.class, all_id);
    }

    public List<AllReservation> findAll() {
        return em.createQuery("select a from AllReservation a", AllReservation.class).getResultList();
    }
}
