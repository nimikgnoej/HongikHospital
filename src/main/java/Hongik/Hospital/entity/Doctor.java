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
    private String did;

    private int career;

    private String name;

    private String phone;

    private int dept_id;

    @OneToMany(mappedBy = "doctor")
    private List<Reservation> reservationList = new ArrayList<>();

}

