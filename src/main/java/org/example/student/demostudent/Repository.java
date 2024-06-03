package org.example.student.demostudent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Model,Long> {

    @Query("SELECT s FROM Model s WHERE s.email = ?1")
    Optional<Model> findStudentByEmail(String email);

}
