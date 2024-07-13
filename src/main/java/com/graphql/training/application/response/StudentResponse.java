package com.graphql.training.application.response;

import com.graphql.training.application.constant.SubjectName;
import com.graphql.training.application.entity.Student;
import com.graphql.training.application.entity.Subject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
public class StudentResponse {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String street;
    private String city;
    private List<SubjectResponse> learningSubjects;
    private Student student;

    public StudentResponse(final Student student) {
        this.id = student.getId();
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();
        this.email = student.getEmail();
        this.street = student.getAddress().getStreet();
        this.city = student.getAddress().getCity();
        this.student = student;

//        //todo: implement this via resolver
//        if (student.getLearningSubjects() != null) {
//            learningSubjects = new ArrayList<SubjectResponse>();
//            for (Subject subject : student.getLearningSubjects()) {
//                learningSubjects.add(new SubjectResponse(subject));
//
//            }
//        }
    }
}
