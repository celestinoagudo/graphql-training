package com.graphql.training.application.entity;

import com.graphql.training.application.request.CreateStudentRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "student")
    private List<Subject> learningSubjects;

    public Student(final CreateStudentRequest createStudentRequest){
        setFirstName(createStudentRequest.getFirstName());
        setLastName(createStudentRequest.getLastName());
        setEmail(createStudentRequest.getEmail());
    }
}
