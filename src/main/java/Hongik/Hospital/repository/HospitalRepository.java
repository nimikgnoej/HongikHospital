package Hongik.Hospital.repository;

import Hongik.Hospital.entity.Hospital;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class HospitalRepository {
    @PersistenceContext
    private EntityManager em;

    public void save(Hospital hospital) {
        em.persist(hospital);
    }

    public Hospital findOne(Long hid) {
        return em.find(Hospital.class, hid);
    }

    public List<Hospital> findAll() {
        return em.createQuery("select h from Hospital h", Hospital.class).getResultList();
    }
}
