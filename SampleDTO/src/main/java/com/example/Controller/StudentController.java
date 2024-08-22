package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.DTO.Student_DTO;
import com.example.service.StudentServiceImple;

@RestController
public class StudentController {

	private StudentServiceImple studentService;
    ///setter injection
    @Autowired
    public void setStudentService(StudentServiceImple studentService) {
        this.studentService = studentService;
    }
	 
//    @PostMapping("/add") 
//    public Student_DTO add(@RequestBody Student_DTO dt) {
//   	 return studentService.add(dt); 
//   	 
//   	    }
   	   
    @PostMapping("/add")
    public ResponseEntity<Student_DTO> add(@RequestBody Student_DTO dt) {
        Student_DTO savedStudent = studentService.add(dt);
        //Reponse Entity Contains data + status Show the Client 
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }
    
    
    
    
//    @GetMapping("/getAllstudent")
//    public List<Student_DTO> getAllStudents() {
//        return studentService.getAllStudents();
//    }
    
    
    @GetMapping("/getAll")
    public ResponseEntity<List<Student_DTO>> getAllStudents() {
        List<Student_DTO> students = studentService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    
//    
//    @GetMapping("getStudentById/{id}")
//    public Student_DTO getStudentById(@PathVariable int id) {
//        return studentService.getStudentById(id);
//    }
       
    @GetMapping("/getById/{id}")
    public ResponseEntity<Student_DTO> getStudentById(@PathVariable int id) {
        Student_DTO student = studentService.getStudentById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
    
    
    @PutMapping("/updateById/{id}")
    public ResponseEntity<Student_DTO> updateStudentById(@PathVariable int id, @RequestBody Student_DTO studentDto) {
        Student_DTO updatedStudent = studentService.updateStudentById(id, studentDto);
        return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
    }
    
    
//    @PutMapping("/updateStudentById/{id}")
//    public Student_DTO updateStudentById(@PathVariable int id, @RequestBody Student_DTO studentDto) {
//        return studentService.updateStudentById(id, studentDto);
//    }
    
//    @PatchMapping("patchStudentById/{id}")
//    public Student_DTO patchStudentById(@PathVariable int id, @RequestBody Student_DTO studentDto) {
//        return studentService.patchStudentById(id, studentDto);
//    }
    
    @PatchMapping("/patchById/{id}")
    public ResponseEntity<Student_DTO> patchStudentById(@PathVariable int id, @RequestBody Student_DTO studentDto) {
        Student_DTO patchedStudent = studentService.patchStudentById(id, studentDto);
        return new ResponseEntity<>(patchedStudent, HttpStatus.OK);
    }
    
    
//    @DeleteMapping("deleteStudentById/{id}")
//    public void deleteStudentById(@PathVariable int id) {
//        studentService.deleteStudentById(id);
//    }
    
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteStudentById(@PathVariable int id) {
        studentService.deleteStudentById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    
}
