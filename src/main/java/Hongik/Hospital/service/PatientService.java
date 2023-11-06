package Hongik.Hospital.service;

import Hongik.Hospital.entity.Gender;
import Hongik.Hospital.entity.Patient;
import Hongik.Hospital.entity.Reservation;
import Hongik.Hospital.repository.PatientRepository;
import Hongik.Hospital.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;
    private final ReservationRepository reservationRepository;

    @Transactional
    public Long enroll(Patient patient) {
        patientRepository.save(patient);
        return patient.getPid();
    }

    //조회 메서드
    public Patient findById(Long pid) {
        return patientRepository.findOne(pid);
    }

    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    public List<Patient> findByName(String name) {
        return patientRepository.findByName(name);
    }
}
