package com.graphql.training.application.query.resolver;

import com.graphql.training.application.entity.Student;
import com.graphql.training.application.entity.Subject;
import com.graphql.training.application.response.StudentResponse;
import com.graphql.training.application.response.SubjectResponse;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentResponseResolver implements GraphQLResolver<StudentResponse> {

    //TODO: fix this, not working right nah
    public List<SubjectResponse> learningSubjects(final StudentResponse studentResponse) {
        Student student = studentResponse.getStudent();
        final List<SubjectResponse> learningSubjects = new ArrayList<>();
        if (student.getLearningSubjects() != null) {
            for (Subject subject : student.getLearningSubjects()) {
                learningSubjects.add(new SubjectResponse(subject));
            }
        }
        return learningSubjects;
    }
}
