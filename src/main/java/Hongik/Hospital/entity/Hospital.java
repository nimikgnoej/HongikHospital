package Hongik.Hospital.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
public class Hospital {
    @Id
    @GeneratedValue
    private String hid;

    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "hospital")
    private List<Department> departmentList = new ArrayList<>();
}
