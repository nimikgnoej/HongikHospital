package Hongik.Hospital.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Doctor {
    @Id
    @GeneratedValue
    private Long did;

    private int career;

    private String name;

    private String phone;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "dept_id")
    private Department department;

    @OneToMany(mappedBy = "doctor")
    private List<Reservation> reservationList = new ArrayList<>();

}

