package com.example.ETB.model;

import javax.persistence.*;

@Entity
@Table(name = "user_data")
public class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "age")
    private Integer age;

    @Column(name = "email_id")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "mobile_number")
    private String mobileNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
