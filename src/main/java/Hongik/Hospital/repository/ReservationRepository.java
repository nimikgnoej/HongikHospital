package Hongik.Hospital.repository;

import Hongik.Hospital.entity.Reservation;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ReservationRepository {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Long save(Reservation reservation) {
        em.persist(reservation);
        return reservation.getReservation_id();
    }

    public Reservation findOne(Long reservation_id) {
        return em.find(Reservation.class, reservation_id);
    }

    public List<Reservation> findAll() {
        return em.createQuery("select r from Reservation r", Reservation.class).getResultList();
    }
}
