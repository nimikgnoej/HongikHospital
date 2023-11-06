package Hongik.Hospital.service;

import Hongik.Hospital.entity.Department;
import Hongik.Hospital.entity.Doctor;
import Hongik.Hospital.repository.DepartmentRepository;
import Hongik.Hospital.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;
    private final DepartmentRepository departmentRepository;

    public Doctor enrollDoc(Long doctorId, Department department) { //의사와 진료과를 결합한다.
        Doctor findDoc = doctorRepository.findOne(doctorId);
        findDoc.setDepartment(department);
        department.getDoctorList().add(findDoc);
        doctorRepository.save(findDoc);
        departmentRepository.save(department);
        return findDoc;
    }
}
