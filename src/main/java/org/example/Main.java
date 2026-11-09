package org.example;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.example.DSA.MaskEmail;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println(1 / 2);
    }


    public record EnrollmentRequest(@NotNull Long studentId, @NotBlank String courseCode) {
    }

    public record EnrollmentResponse(long studentId, String courseCode) {
    }

    public class DuplicateEnrollmentException extends RuntimeException {
    }

    public interface EnrollmentService {
        // throws DuplicateEnrollmentException if the student is already enrolled
        EnrollmentResponse enroll(long studentId, String courseCode);
    }

    @RestController
    @RequestMapping("/enrollments")
    public class EnrollmentController {
        private final EnrollmentService service;

        public EnrollmentController(EnrollmentService service) {
            this.service = service;
        }

        @PostMapping
        public ResponseEntity<EnrollmentResponse> enroll(@Valid @RequestBody EnrollmentRequest request) {
            EnrollmentResponse response = service.enroll(request.studentId(), request.courseCode());
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }
    }


    @RestControllerAdvice
     class ExceptionHandling {

        @ExceptionHandler(DuplicateEnrollmentException.class)
        public ResponseEntity<String> handleDuplication(){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Student is already enrolled in this course");
        }
    }
}
