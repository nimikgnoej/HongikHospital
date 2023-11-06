package Hongik.Hospital.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Department {
    @Id
    @GeneratedValue
    private Long deptid;

    private String dept_name;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "hid")
    private Hospital hospital;

    @OneToMany(mappedBy = "department")
    private List<Doctor> doctorList = new ArrayList<>();

}
