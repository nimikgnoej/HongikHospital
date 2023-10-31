package Hongik.Hospital.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Department {
    @Id
    @GeneratedValue
    private String deptid;

    private String dept_name;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "hid")
    private Hospital hospital;
}
