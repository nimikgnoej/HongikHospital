package Hongik.Hospital.service;

import Hongik.Hospital.entity.Department;
import Hongik.Hospital.entity.Hospital;
import Hongik.Hospital.repository.DepartmentRepository;
import Hongik.Hospital.repository.HospitalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class HospitalService {
    private final HospitalRepository hospitalRepository;
    private final DepartmentRepository departmentRepository;

    public void makeHospital(Hospital hospital, Department department) {
        Hospital findHos = hospitalRepository.findOne(hospital.getHid());
        Department findDept = departmentRepository.findOne(department.getDeptid());
        findHos.getDepartmentList().add(department);
        findDept.setHospital(hospital);
        hospitalRepository.save(hospital);
        departmentRepository.save(department);
    }
}
