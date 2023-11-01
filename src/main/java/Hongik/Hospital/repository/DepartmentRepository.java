package Hongik.Hospital.repository;

import Hongik.Hospital.entity.Department;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class DepartmentRepository {
    @PersistenceContext
    private EntityManager em;

    public void save(Department department) {
        em.persist(department);
    }

    public Department findOne(String dept_id) {
        return em.find(Department.class, dept_id);
    }

    public List<Department> findAll() {
        return em.createQuery("select de from Department de", Department.class).getResultList();
    }
}
