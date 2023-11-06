package Hongik.Hospital.service;

import Hongik.Hospital.entity.Doctor;
import Hongik.Hospital.entity.Gender;
import Hongik.Hospital.entity.Patient;
import Hongik.Hospital.entity.Reservation;
import Hongik.Hospital.repository.ReservationRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
class ReservationServiceTest {
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private PatientService patientService;
    @Test
    @Rollback
    public void 예약() throws Exception {
        //given
        Patient patient = new Patient();
        patient.setAge(11);
        patient.setGender(Gender.MALE);
        patient.setName("ㅇㄴㅁㅇㅁㄴ");

        Doctor doctor = new Doctor();
        doctor.setName("정기민");
        doctor.setCareer(101);
        doctor.setPhone("010-3123-1321");

        patientService.enroll(patient);

        //when
        Long Id = reservationService.reserve(patient.getPid(), doctor.getDid());
        Reservation findOne = reservationRepository.findOne(Id);
        System.out.println("findOne = " + findOne);
        
        List<Reservation> all = reservationRepository.findAll();
        for (Reservation reservation : all) {
            System.out.println("reservation = " + reservation.getPatient());
        }
        //then

    }
}