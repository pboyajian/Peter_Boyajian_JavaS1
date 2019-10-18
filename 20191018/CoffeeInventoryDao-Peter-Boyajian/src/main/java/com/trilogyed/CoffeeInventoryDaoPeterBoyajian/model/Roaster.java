package com.trilogyed.CoffeeInventoryDaoPeterBoyajian.model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Size;
import java.util.Objects;

public class Roaster {
    private int roaster_id;
    private String name;
    private String street;
    private String city;
    //@Length(min = 0,max = 2)
    @Size(min = 2,max = 2)
    private String state;
    private String postal_code;
    private String phone;
    private String email;
    private String note;

    public Roaster() {
    }

    @Override
    public String toString() {
        return "Roaster{" +
                "roaster_id=" + roaster_id +
                ", name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postal_code='" + postal_code + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", note='" + note + '\'' +
                '}';
    }

    public Roaster(String name, String street, String city, String state, String postal_code, String phone, String email, String note) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.postal_code = postal_code;
        this.phone = phone;
        this.email = email;
        this.note = note;
    }

    public Roaster(int roaster_id, String name, String street, String city, String state, String postal_code, String phone, String email, String note) {
        this.roaster_id = roaster_id;
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.postal_code = postal_code;
        this.phone = phone;
        this.email = email;
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Roaster roaster = (Roaster) o;
        return roaster_id == roaster.roaster_id &&
                Objects.equals(name, roaster.name) &&
                Objects.equals(street, roaster.street) &&
                Objects.equals(city, roaster.city) &&
                Objects.equals(state, roaster.state) &&
                Objects.equals(postal_code, roaster.postal_code) &&
                Objects.equals(phone, roaster.phone) &&
                Objects.equals(email, roaster.email) &&
                Objects.equals(note, roaster.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roaster_id, name, street, city, state, postal_code, phone, email, note);
    }

    public int getRoaster_id() {
        return roaster_id;
    }

    public void setRoaster_id(int roaster_id) {
        this.roaster_id = roaster_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
