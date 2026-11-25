
package com.exammanagement.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "registration_id", unique = true, nullable = false)
    private String registrationId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, length = 500)
    private String address;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    private String qualification;

    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal percentage;

    @Column(name = "contact_no", nullable = false)
    private String contactNo;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    // Default constructor required by JPA
    public Student() {
    }

    // Constructor
    public Student(String registrationId, String name,
                   String address, String gender, Integer age,
                   String qualification, BigDecimal percentage,
                   String contactNo, String passwordHash) {

        this.registrationId = registrationId;
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.age = age;
        this.qualification = qualification;
        this.percentage = percentage;
        this.contactNo = contactNo;
        this.passwordHash = passwordHash;
        this.createdAt = LocalDateTime.now();
    }

    // Getters

    public Long getId() {
        return id;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getGender() {
        return gender;
    }

    public Integer getAge() {
        return age;
    }

    public String getQualification() {
        return qualification;
    }

    public BigDecimal getPercentage() {
        return percentage;
    }

    public String getContactNo() {
        return contactNo;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
