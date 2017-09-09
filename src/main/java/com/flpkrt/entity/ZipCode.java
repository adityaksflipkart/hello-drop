package com.flpkrt.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ZipCode implements Serializable{


    private String zipcode;

    public ZipCode(String value) {
        this.zipcode = value;
    }

    public ZipCode(){

    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZipCode zipCode = (ZipCode) o;

        return zipcode.equals(zipCode.zipcode);
    }

    @Override
    public int hashCode() {
        return zipcode.hashCode();
    }

    @Override
    public String toString() {
        return "ZipCode{" +
                "zipcode='" + zipcode + '\'' +
                '}';
    }
}
