package com.graphql.training.application.repository;

import com.graphql.training.application.entity.Student;
import com.graphql.training.application.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, String> {
}
