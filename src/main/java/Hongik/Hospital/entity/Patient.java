package Hongik.Hospital.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Patient {
    @Id
    @GeneratedValue
    private String pid;

    private int age;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String name;

    @OneToMany(mappedBy = "patient")
    private List<Reservation> reservationList;

}
