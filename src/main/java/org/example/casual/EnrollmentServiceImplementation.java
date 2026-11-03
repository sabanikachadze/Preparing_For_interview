package org.example.casual;

import org.example.Pojos.Enrollment;
import org.example.fixCode.DataAccessException;
import org.example.fixCode.DuplicateEnrollmentException;
import org.example.fixCode.EnrollmentResponse;
import org.example.fixCode.EnrollmentService;

public class EnrollmentServiceImplementation implements EnrollmentService {

    private final EnrollmentRepository repository;

    public EnrollmentServiceImplementation(EnrollmentRepository repository) {
        this.repository = repository;
    }


    @Override
    public EnrollmentResponse enroll(long studentId, String courseCode) {
        Enrollment enrollment;
        try {
            enrollment = repository.enrollStudent(studentId);
        } catch (DataAccessException e) {
            throw new DuplicateEnrollmentException();
        }
        return new EnrollmentResponse(enrollment.id(),
                                        enrollment.studentId(),
                                        enrollment.courseCode());
    }
}
