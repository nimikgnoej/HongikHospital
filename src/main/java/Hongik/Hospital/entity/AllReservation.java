package Hongik.Hospital.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class AllReservation {
    @Id
    @GeneratedValue
    private Long all_id;

    private String hospital;

    private String dept;

    private String doctor_name;

    private String patient_name;

    private LocalDateTime time;

}
