package org.example.student.demostudent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class Controller {

    private final Service service;

    @Autowired
    public Controller(Service service) {
        this.service = service;
    }


    @GetMapping()
	public List<Model> getStudents(){
        return service.getStudents();
	}

    @PostMapping
    public void registerNewStudent(@RequestBody Model student){
        service.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentID") Long studentId){
        service.deleteStudent(studentId);

    }
}
