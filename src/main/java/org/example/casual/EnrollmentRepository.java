package org.example.casual;

import org.example.Pojos.Enrollment;

public class EnrollmentRepository {

    public Enrollment enrollStudent(Long studentId){
        return new Enrollment ( 2, 1, "sadasfa");
    }
}
