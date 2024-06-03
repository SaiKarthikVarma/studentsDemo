package org.example.student.demostudent;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {

	private final Repository repository;

	@Autowired
    public Service(Repository repository) {
        this.repository = repository;
    }

    public List<Model> getStudents(){
		return repository.findAll();
    }

    public void addNewStudent(Model student) {
        Optional<Model> studentByEmail = repository.findStudentByEmail(student.getEmail());

        if(studentByEmail.isPresent()){
            throw new IllegalStateException("email taken");
        }
        repository.save(student);
    }

    public void deleteStudent(Long studentID) {
        boolean exists = repository.existsById(studentID);
        if(!exists){
            throw new IllegalStateException(
                    "student with id " + studentID + " does not exists");
        }
        repository.deleteById(studentID);
    }
}
