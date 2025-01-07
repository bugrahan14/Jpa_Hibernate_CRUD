package com.bugrahan.cruddemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="student")
public class Student {

    // DEFİNE FİELDS

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;


    // DEFİNE CONSTRUCTOR

    public Student(){

    }

    public Student(String firstName,String lastName,String email){
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
    }


    // GET AND SET METHODS

    // İD
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // FİRST NAME
    public void setFirstName(String firstName){
        this.firstName=firstName;
    }

    public String getFirstName(){
        return firstName;
    }

    // LAST NAME
    public void setLastName(String lastName){
        this.lastName=lastName;
    }

    public String getLastName(){
        return lastName;
    }

    // E-MAİL
    public void setEmail(String email){
        this.email=email;
    }

    public String getEmail(){
        return email;
    }


    // TO STRİNG METHODS

    @Override
    public String toString() {
        return  "Öğrenci Bilgileri:\n" +
                "ID: " + id + "\n" +
                "Ad: " + firstName + "\n" +
                "Soyad: " + lastName + "\n" +
                "E-posta: " + email;
    }
}
