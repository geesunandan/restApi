package com.example.demo.Service;

import com.example.demo.Entity.Student;
import com.example.demo.Repository.StudentRepository;
import net.bytebuddy.TypeCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    //Saves data in the database
    public Student saveStudent(Student student){
        return studentRepository.save(student);

    }

    //Saves multiple data in the database
    public List<Student> saveStudents(List<Student> student) {

        return studentRepository.saveAll(student);
    }

    //Sorting students by fullname
    public List<Student> sortStudent(){
        return studentRepository.findAll(Sort.by(Sort.Direction.ASC,"fullname"));
    }

    //returns list of the students
    public List<Student> getStudent(){
        return studentRepository.findAll();
    }

    //Finds students by username
    public Student getByusername(String username){
        return studentRepository.findByusername(username);
    }

    //Finds students by id
    public Student findStudent (int id){
        return  studentRepository.findById(id).orElse(null);
    }


    // delete student by id
    public String deleteStudent(int id){
         studentRepository.deleteById(id);
         return "Student Removed " + id;
    }

    //Update Student

    public Student updateStudent(Student student){

        Student student1 = studentRepository.findById(student.getId()).orElse(null);
        student1.setFullname(student.getFullname());
        student1.setPassword(student.getPassword());
        student1.setUsername(student.getUsername());
        student1.setRole(student.getRole());

        return studentRepository.save(student1);
    }
}
