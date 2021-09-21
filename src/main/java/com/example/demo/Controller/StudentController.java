package com.example.demo.Controller;

import com.example.demo.Entity.Student;
import com.example.demo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/addStudent")
    public Student addUser(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @PostMapping("/addStudents")
    public List<Student> addStudents(@RequestBody List<Student> student) {
        return studentService.saveStudents(student);
    }

    //End of post mapping

    @GetMapping("/getStudents")
    public List<Student> getStudents() {
        return studentService.getStudent();
    }

    @GetMapping("/getStudent/{id}")
    public Student getStudentById(@PathVariable int id) {
        return studentService.findStudent(id);
    }

    @GetMapping("/getStudentByusername/{username}")
    public Student getStudentByusername(@PathVariable String username) {
        return studentService.getByusername(username);
    }

    @GetMapping("/sortStudent")
    public List<Student> sortStudent(){
        return studentService.sortStudent();
    }
    //End of get Request


    //Update using put request
    @PutMapping("/updateStudent")
    public Student updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    //Delete using delete request
    @DeleteMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable int id) {
        return studentService.deleteStudent(id);
    }

}


