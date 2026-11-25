
package com.exammanagement.service;

import com.exammanagement.dto.StudentRegistrationRequest;
import com.exammanagement.dto.StudentRegistrationResponse;
import com.exammanagement.entity.Student;
import com.exammanagement.repository.StudentRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;

    // Constructor injection
    public StudentService(
            StudentRepository studentRepository,
            PasswordEncoder passwordEncoder) {

        this.studentRepository = studentRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Student Registration
    @Transactional
    public StudentRegistrationResponse registerStudent(
            StudentRegistrationRequest request) {

        // Step 1: Check password confirmation
        if (!request.password().equals(request.confirmPassword())) {
            throw new IllegalArgumentException(
                    "Password and Confirm Password do not match");
        }

        // Step 2: Generate unique Registration ID
        String registrationId;

        do {
            registrationId = "STU" +
                    UUID.randomUUID()
                            .toString()
                            .replace("-", "")
                            .substring(0, 8)
                            .toUpperCase();

        } while (studentRepository.existsByRegistrationId(registrationId));

        // Step 3: Encrypt password using BCrypt
        String encodedPassword =
                passwordEncoder.encode(request.password());

        // Step 4: Create Student object
        Student student = new Student(
                registrationId,
                request.name(),
                request.address(),
                request.gender(),
                request.age(),
                request.qualification(),
                request.percentage(),
                request.contactNo(),
                encodedPassword
        );

        // Step 5: Save student in MySQL
        studentRepository.save(student);

        // Step 6: Return registration response
        return new StudentRegistrationResponse(
                registrationId,
                "Student registered successfully"
        );
    }
}
