package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.DTO.Student_DTO;
import com.example.Exception.BadRequestException;
import com.example.Exception.ResourceNotFoundException;
import com.example.Repository.StudentRepository;
import com.example.entity.Student;
import com.example.util.StudentUtil;

@Service
public class StudentServiceImple implements StudentSerive {
       ///D
	private StudentUtil util;
	private StudentRepository sr;
	
	public StudentServiceImple( StudentUtil util,StudentRepository sr) {
		   this.util=util;
		   this.sr=sr;
	}

//	@Override
//	public Student_DTO add(Student_DTO std) {
//		//Student_DTO std = new Student_DTO();
//	    Student save = sr.save(util.dtoToEntity(std));
//	    System.out.println("============================="+save);
//		return util.entityToDto(save);
//	}
	
	@Override
    public Student_DTO add(Student_DTO std) {
        if (std.getUser_name() == null || std.getEmail() == null) {
            throw new BadRequestException("Student name and email cannot be null.");
        }
        Student save = sr.save(util.dtoToEntity(std));
        return util.entityToDto(save);
    }  
	
	 

	
//	@Override
//    public List<Student_DTO> getAllStudents() {
//        List<Student> students = sr.findAll();
//        System.out.println("==============="+students);
//        List<Student_DTO> studentDtos = new ArrayList<>();
//        
//        for (Student student : students) {
//            studentDtos.add(util.entityToDto(student));
//        }
//        System.out.println("==============="+studentDtos);
//        return studentDtos;
//    }

	@Override
    public List<Student_DTO> getAllStudents() {
        List<Student> students = sr.findAll();
        if (students.isEmpty()) {
            throw new ResourceNotFoundException("No students found.");
        }
        List<Student_DTO> studentDtos = new ArrayList<>();
        for (Student student : students) {
            studentDtos.add(util.entityToDto(student));
        }
        return studentDtos;
    }
	
	
//    @Override
//    public Student_DTO getStudentById(int id) {
//        Optional<Student> student = sr.findById(id);
//        if (student.isPresent()) {
//            return util.entityToDto(student.get());
//        } else {
//       throw new RuntimeException("Student not found with id: " + id);
//        }
//    }
    
    
    @Override
    public Student_DTO getStudentById(int id) {
        Optional<Student> student = sr.findById(id);
        if (student.isPresent()) {
            return util.entityToDto(student.get());
        } else {
            throw new ResourceNotFoundException("Student not found with id: " + id);
        }
    }
        

    @Override
    public Student_DTO updateStudentById(int id, Student_DTO studentDto) {
        Optional<Student> existStudent = sr.findById(id);
        if (existStudent.isPresent()) {
            Student existingStudent = existStudent.get();
            existingStudent.setName(studentDto.getUser_name());
            existingStudent.setAddress(studentDto.getAddress());
            existingStudent.setEmail(studentDto.getEmail());
            Student updatedStudent = sr.save(existingStudent);
            return util.entityToDto(updatedStudent);
        } else {
            throw new ResourceNotFoundException("Student not found with id: " + id);
        }
    }
    
    
    @Override
    public Student_DTO patchStudentById(int id, Student_DTO studentDto) {
        Optional<Student> existingStudentOpt = sr.findById(id);
        if (existingStudentOpt.isPresent()) {
            Student existingStudent = existingStudentOpt.get();
            if (studentDto.getUser_name() != null) {
                existingStudent.setName(studentDto.getUser_name());
            }
            if (studentDto.getAddress() != null) {
                existingStudent.setAddress(studentDto.getAddress());
            }
            Student updatedStudent = sr.save(existingStudent);
            return util.entityToDto(updatedStudent);
        } else {
            throw new ResourceNotFoundException("Student not found with id: " + id);
        }
    }

    @Override
    public void deleteStudentById(int id) {
        if (sr.existsById(id)) {
            sr.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Student not found with id: " + id);
        }
    }

	
    
     
	
	   
}
