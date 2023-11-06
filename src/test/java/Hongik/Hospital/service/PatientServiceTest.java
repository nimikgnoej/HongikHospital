package Hongik.Hospital.service;

import Hongik.Hospital.entity.*;
import Hongik.Hospital.repository.PatientRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class PatientServiceTest {
    @Autowired
    private PatientService patientService;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private ReservationService reservationService;
    @Test
    @Rollback(value = false)
    public void 환자_등록() throws Exception {
        //given
        Patient patient1 = new Patient();
        patient1.setGender(Gender.MALE);
        patient1.setName("정기민");
        patient1.setAge(24);

        //when
        Long enrolledId = patientService.enroll(patient1);
        //then
        Assertions.assertThat(enrolledId).isEqualTo(patient1.getPid());
        Assertions.assertThat(patientRepository.findOne(1L)).isEqualTo(patient1);
    }
    @Test
    public void 환자_조회() throws Exception {
        //given
        Patient patient1 = new Patient();
        patient1.setGender(Gender.MALE);
        patient1.setName("정기민");
        patient1.setAge(24);

        Patient patient2 = new Patient();
        patient2.setGender(Gender.FEMALE);
        patient2.setName("김수은");
        patient2.setAge(24);
        //when
        Long enrolled1 = patientService.enroll(patient1);
        Long enrolled2 = patientService.enroll(patient2);
        List<Patient> all = patientService.findAll();
        //then
        for (Patient user : all) {
            System.out.println("User ID: " + user.getPid());
            System.out.println("User Name: " + user.getName());
            System.out.println();
        }
    }

    @Test
    @Rollback(value = false)
    public void 예약() throws Exception {
        //given
        Patient patient = new Patient();
        patient.setGender(Gender.MALE);
        patient.setName("정기민");
        patient.setAge(24);

        Doctor doc = new Doctor();
        doc.setCareer(10);
        doc.setPhone("010-9031-4594");
        doc.setName("김수은");

        Reservation reservation = new Reservation();
        reservation.setPatient(patient);
        reservation.setDoctor(doc);
        reservation.setTime(LocalDateTime.now());
        reservation.setStatus(Status.OK);
        //when
        //reservationService.reserve(reservation);
        Reservation byId = reservationService.findById(1L);
        //then
        System.out.println("byId.getPatient() = " + byId.getPatient().getName());
        System.out.println("byId.getDoctor() = " + byId.getDoctor().getName());

    }
}