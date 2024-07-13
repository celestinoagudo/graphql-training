package com.graphql.training.application.controller;

import com.graphql.training.application.constant.SubjectName;
import com.graphql.training.application.query.Query;
import com.graphql.training.application.request.CreateStudentRequest;
import com.graphql.training.application.request.SampleRequest;
import com.graphql.training.application.response.StudentResponse;
import com.graphql.training.application.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class AppController {

    private final Query query;
    private final StudentService studentService;

    @QueryMapping
    public String firstQuery() {
        return query.firstQuery();
    }

    @QueryMapping
    public String secondQuery() {
        return query.secondQuery();
    }

    @QueryMapping
    public String getFullName(@Argument String firstName, @Argument final String lastName) {
        return query.getFullName(firstName, lastName);
    }

    @QueryMapping
    public String getFullNameViaJSON(@Argument final SampleRequest sampleRequest) {
        return query.getFullNameViaJSON(sampleRequest);
    }

    @QueryMapping
    public StudentResponse getStudentById(@Argument final String id) {
        return query.getStudentById(id);
    }

    @MutationMapping
    public StudentResponse createStudent(@Argument final CreateStudentRequest createStudentRequest) {
        return query.createStudent(createStudentRequest);
    }
}
