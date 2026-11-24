
// Open Admin or Student Login page

function openLogin(userType) {

    if (userType === "Admin") {

        window.location.href = "admin-login.html";

    }

    else if (userType === "Student") {

        window.location.href = "student-login.html";

    }

}


// Open New Student Registration page

function openRegistration() {

    window.location.href = "student-registration.html";

}


// Handle Admin and Student Login Form

function handleLogin(event, userType) {

    event.preventDefault();

    if (userType === "Admin") {

        let email = document.getElementById("adminEmail").value;

        alert("Admin login form submitted!\nEmail: " + email);

    }

    else if (userType === "Student") {

        let registrationId = document.getElementById("studentId").value;

        alert("Student login form submitted!\nRegistration ID: " + registrationId);

    }

}


// Validate New Student Registration Form

function handleRegistration(event) {

    event.preventDefault();

    let password = document.getElementById("password").value;

    let confirmPassword = document.getElementById("confirmPassword").value;

    if (password !== confirmPassword) {

        alert("Password and Confirm Password do not match.");

        return;

    }

    alert(
        "Registration form validation successful!\n\n" +
        "The actual student account will be created after " +
        "connecting the form to the Java Spring Boot backend."
    );

}
