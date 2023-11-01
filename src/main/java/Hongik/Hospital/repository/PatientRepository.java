package Hongik.Hospital.repository;

import Hongik.Hospital.entity.Doctor;
import Hongik.Hospital.entity.Patient;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class PatientRepository {
    @PersistenceContext
    private EntityManager em;

    public void save(Patient patient) {
        em.persist(patient);
    }

    public Patient findOne(String pid) { //의사 PK로 의사 조회
        return em.find(Patient.class,pid);
    }

    public List<Patient> findAll() {
        return em.createQuery("select p from Patient p", Patient.class).getResultList();
    }

    public List<Patient> findByName(String name) {
        return em.createQuery("select p from Patient p where p.name = :name", Patient.class)
                .setParameter("name", name)
                .getResultList();
    }
}
