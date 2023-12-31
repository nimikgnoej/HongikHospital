package Hongik.Hospital.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter @Setter
public class Address {
    public Address(String city,String street, String zipcode){
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
    private String city;
    private String street;
    private String zipcode;

    public Address() {

    }
}
