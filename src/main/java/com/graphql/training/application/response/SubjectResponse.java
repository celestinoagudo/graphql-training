package com.graphql.training.application.response;

import com.graphql.training.application.entity.Subject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubjectResponse {
    private String id;
    private String subjectName;
    private Double marksObtained;

    public SubjectResponse(Subject subject) {
        this.id = subject.getId();
        this.subjectName = subject.getSubjectName();
        this.marksObtained = subject.getMarksObtained();
    }
}
