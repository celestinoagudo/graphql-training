package com.graphql.training.application.query;

import com.graphql.training.application.constant.SubjectName;
import com.graphql.training.application.entity.Student;
import com.graphql.training.application.request.CreateStudentRequest;
import com.graphql.training.application.request.SampleRequest;
import com.graphql.training.application.response.StudentResponse;
import com.graphql.training.application.service.StudentService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Query implements GraphQLQueryResolver {

    private final StudentService studentService;

    public String firstQuery() {
        return "First Query";
    }

    public String secondQuery() {
        return "Second Query";
    }

    public String getFullName(final String firstName, final String lastName) {
        return "%s %s".formatted(firstName, lastName);
    }

    public String getFullNameViaJSON(final SampleRequest sampleRequest) {
        return "%s %s".formatted(sampleRequest.getFirstName(), sampleRequest.getLastName());
    }

    public StudentResponse getStudentById(final String id) {
        return new StudentResponse(studentService.getStudentById(id));
    }

    public StudentResponse createStudent(final CreateStudentRequest createStudentRequest) {
        return new StudentResponse(studentService.createStudent(createStudentRequest));
    }
}
