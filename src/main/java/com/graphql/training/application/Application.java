package com.graphql.training.application;

import com.graphql.training.application.entity.Address;
import com.graphql.training.application.entity.Student;
import com.graphql.training.application.entity.Subject;
import com.graphql.training.application.repository.AddressRepository;
import com.graphql.training.application.repository.StudentRepository;
import com.graphql.training.application.repository.SubjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.UUID;

@SpringBootApplication
@AllArgsConstructor
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    @Autowired
    CommandLineRunner dataGenerator(final StudentRepository studentRepository,
                                    final AddressRepository addressRepository,
                                    final SubjectRepository subjectRepository) {
        return args -> {
            final Student firstStudent = new Student();
            firstStudent.setId(UUID.randomUUID().toString());
            firstStudent.setFirstName("John");
            firstStudent.setLastName("Wick");
            final Address firstAddress = new Address();
            firstAddress.setId(UUID.randomUUID().toString());
            firstAddress.setCity("LA");
            firstAddress.setStreet("O' Block");
            firstStudent.setAddress(addressRepository.save(firstAddress));
            firstStudent.setEmail("johnwick@mail.com");

            final Student secondStudent = new Student();
            secondStudent.setId(UUID.randomUUID().toString());
            secondStudent.setFirstName("Huffman");
            secondStudent.setLastName("Coding");
            final Address secondAddress = new Address();
            secondAddress.setId(UUID.randomUUID().toString());
            secondAddress.setCity("SA");
            secondAddress.setStreet("Texas");
            secondStudent.setAddress(addressRepository.save(secondAddress));
            secondStudent.setEmail("huffmancoding@mail.com");

            studentRepository.save(firstStudent);
            studentRepository.save(secondStudent);

            final Subject firstSubject = new Subject();
            firstSubject.setId(UUID.randomUUID().toString());
            firstSubject.setSubjectName("Computational Intelligence");
            firstSubject.setMarksObtained(1.0);
            firstSubject.setStudent(firstStudent);

            final Subject secondSubject = new Subject();
            secondSubject.setId(UUID.randomUUID().toString());
            secondSubject.setSubjectName("Modelling & Simulation");
            secondSubject.setMarksObtained(1.25);
            secondSubject.setStudent(secondStudent);

            final Subject thirdSubject = new Subject();
            thirdSubject.setId(UUID.randomUUID().toString());
            thirdSubject.setSubjectName("Compiler Design");
            thirdSubject.setMarksObtained(1.5);
            thirdSubject.setStudent(firstStudent);

            subjectRepository.save(firstSubject);
            subjectRepository.save(secondSubject);
            subjectRepository.save(thirdSubject);
        };
    }

}
