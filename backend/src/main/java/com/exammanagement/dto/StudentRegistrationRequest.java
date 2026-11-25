
package com.exammanagement.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record StudentRegistrationRequest(

    @NotBlank(message = "Name is required")
    @Size(max = 100)
    String name,

    @NotBlank(message = "Address is required")
    @Size(max = 500)
    String address,

    @NotBlank(message = "Gender is required")
    @Pattern(regexp = "Male|Female|Other",
             message = "Please select a valid gender")
    String gender,

    @NotNull(message = "Age is required")
    @Min(value = 1, message = "Age must be at least 1")
    @Max(value = 120, message = "Age cannot exceed 120")
    Integer age,

    @NotBlank(message = "Qualification is required")
    String qualification,

    @NotNull(message = "Percentage is required")
    @DecimalMin(value = "0.0")
    @DecimalMax(value = "100.0")
    BigDecimal percentage,

    @NotBlank(message = "Contact number is required")
    @Pattern(regexp = "[0-9]{10}",
             message = "Contact number must contain 10 digits")
    String contactNo,

    @NotBlank(message = "Password is required")
    @Size(min = 8, max = 72,
          message = "Password must contain 8 to 72 characters")
    String password,

    @NotBlank(message = "Please confirm your password")
    String confirmPassword

) {
}
