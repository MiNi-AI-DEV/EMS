
package com.exammanagement.controller;

import com.exammanagement.dto.StudentRegistrationRequest;
import com.exammanagement.dto.StudentRegistrationResponse;
import com.exammanagement.service.StudentService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final StudentService studentService;

    // Constructor injection
    public AuthController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Student Registration API
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public StudentRegistrationResponse registerStudent(
            @Valid @RequestBody StudentRegistrationRequest request) {

        return studentService.registerStudent(request);
    }
}
