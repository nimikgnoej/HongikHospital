package Hongik.Hospital.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter @Setter
public class Address {
    private String city;
    private String street;
    private String zipcode;
}
