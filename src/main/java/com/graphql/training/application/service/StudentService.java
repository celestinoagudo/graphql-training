package com.graphql.training.application.service;

import com.graphql.training.application.entity.Address;
import com.graphql.training.application.entity.Student;
import com.graphql.training.application.entity.Subject;
import com.graphql.training.application.repository.AddressRepository;
import com.graphql.training.application.repository.StudentRepository;
import com.graphql.training.application.repository.SubjectRepository;
import com.graphql.training.application.request.CreateStudentRequest;
import com.graphql.training.application.request.CreateSubjectRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final AddressRepository addressRepository;
    private final SubjectRepository subjectRepository;

    public Student getStudentById(final String id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found for id: %s".formatted(id)));
    }

    public Student createStudent(CreateStudentRequest createStudentRequest) {
        Student student = new Student(createStudentRequest);
        student.setId(UUID.randomUUID().toString());

        Address address = new Address();
        address.setId(UUID.randomUUID().toString());
        address.setStreet(createStudentRequest.getStreet());
        address.setCity(createStudentRequest.getCity());
        addressRepository.save(address);

        student.setAddress(address);
        studentRepository.save(student);

        List<Subject> subjectsList = new ArrayList<>();

        if (createStudentRequest.getSubjectsLearning() != null) {
            for (CreateSubjectRequest createSubjectRequest :
                    createStudentRequest.getSubjectsLearning()) {
                Subject subject = new Subject();
                subject.setId(UUID.randomUUID().toString());
                subject.setSubjectName(createSubjectRequest.getSubjectName());
                subject.setMarksObtained(createSubjectRequest.getMarksObtained());
                subject.setStudent(student);
                subjectsList.add(subject);
            }
            subjectRepository.saveAll(subjectsList);
        }
        student.setLearningSubjects(subjectsList);
        return student;
    }
}
