package Hongik.Hospital.repository;

import Hongik.Hospital.entity.Reservation;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ReservationRepository {
    @PersistenceContext
    private EntityManager em;

    public void save(Reservation reservation) {
        em.persist(reservation);
    }

    public Reservation findOne(Long reservation_id) {
        return em.find(Reservation.class, reservation_id);
    }

    public List<Reservation> findAll() {
        return em.createQuery("select r from Reservation r", Reservation.class).getResultList();
    }
}
