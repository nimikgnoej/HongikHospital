package Hongik.Hospital.service;

import Hongik.Hospital.entity.Doctor;
import Hongik.Hospital.entity.Patient;
import Hongik.Hospital.entity.Reservation;
import Hongik.Hospital.repository.DoctorRepository;
import Hongik.Hospital.repository.PatientRepository;
import Hongik.Hospital.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    @Transactional
    public Long reserve(Long patientId, Long doctorId) {
        Patient pa = patientRepository.findOne(patientId);
        Doctor doc = doctorRepository.findOne(doctorId);
        return reservationRepository.save(Reservation.createReservation(pa,doc));
    }

    public void cancle(Long reservationId) {
        Reservation findOne = reservationRepository.findOne(reservationId);
        findOne.cancle();
    }

    //조회 메서드
    public Reservation findById(Long id) {
        return reservationRepository.findOne(id);
    }

    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }
}
