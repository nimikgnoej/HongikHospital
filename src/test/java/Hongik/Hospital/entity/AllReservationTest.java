package Hongik.Hospital.entity;

import Hongik.Hospital.repository.DepartmentRepository;
import Hongik.Hospital.repository.DoctorRepository;
import Hongik.Hospital.repository.HospitalRepository;
import Hongik.Hospital.service.DoctorService;
import Hongik.Hospital.service.PatientService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.print.Doc;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class AllReservationTest {
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private PatientService patientService;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private HospitalRepository hospitalRepository;
    @Test
    @Rollback(value = false)
    public void 환자_등록() throws Exception {
        //given
        Patient patient = new Patient();
        patient.setName("정기민");
        patient.setGender(Gender.MALE);
        patient.setAge(24);
        //when
        patientService.enroll(patient);
        //then
        Patient find = patientService.findById(patient.getPid());
        Assertions.assertThat(find).isEqualTo(patient);
    }

    @Test
    public void 의사_진료과_등록() throws Exception {
        //given
        Hospital hospital = new Hospital();
        hospital.setName("홍익병원");
        hospital.setAddress(new Address("서울시", "마포구", "101010"));
        hospitalRepository.save(hospital);

        Department department = new Department();
        department.setDept_name("정형외과");
        department.setHospital(hospital);
        departmentRepository.save(department);

        Doctor doctor = new Doctor();
        doctor.setPhone("010-9031-3459");
        doctor.setCareer(10);
        doctor.setName("정기민");
        doctorRepository.save(doctor);

        //when
        doctorService.enrollDoc(doctor.getDid(), department);
        Doctor findDoc = doctorRepository.findOne(doctor.getDid());
        //then
        System.out.println("findDoc = " + findDoc);
    }
}