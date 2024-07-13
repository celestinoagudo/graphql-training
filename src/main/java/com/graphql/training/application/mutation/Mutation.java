package com.graphql.training.application.mutation;

import com.graphql.training.application.request.CreateStudentRequest;
import com.graphql.training.application.response.StudentResponse;
import com.graphql.training.application.service.StudentService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class Mutation implements GraphQLMutationResolver {

    private final StudentService studentService;

    public StudentResponse createStudent(final CreateStudentRequest createStudentRequest) {
        return new StudentResponse(studentService.createStudent(createStudentRequest));
    }
}
