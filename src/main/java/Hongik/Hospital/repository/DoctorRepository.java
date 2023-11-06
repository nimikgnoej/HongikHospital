package Hongik.Hospital.repository;

import Hongik.Hospital.entity.Doctor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class DoctorRepository {
    @PersistenceContext
    private EntityManager em;

    public Long save(Doctor doctor) {
        em.persist(doctor);
        return doctor.getDid();
    }

    public Doctor findOne(Long did) {
        return em.find(Doctor.class, did);
    }

    public List<Doctor> findAll() {
        return em.createQuery("select d from Doctor d", Doctor.class).getResultList();
    }

}
