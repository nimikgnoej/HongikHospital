package Hongik.Hospital.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Reservation {
    @Id
    @GeneratedValue
    @Column(name = "reservation_id")
    private Long reservation_id;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime time;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "pid")
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "did")
    private Doctor doctor;

    public void setPatient(Patient patient) {
        this.patient = patient;
        patient.getReservationList().add(this);
    }
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
        doctor.getReservationList().add(this);
    }

    //예약 생성 메서드
    public static Reservation createReservation(Patient patient, Doctor doctor) {
        Reservation reservation = new Reservation();
        reservation.setDoctor(doctor);
        reservation.setPatient(patient);
        reservation.setTime(LocalDateTime.now());
        reservation.setStatus(Status.OK);
        return reservation;
    }

    public void cancle() {
        this.setStatus(Status.CANCLE);
        this.time = null;
        patient.getReservationList().remove(this);
    }
}
