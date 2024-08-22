package com.example.service;

import java.util.List;

import com.example.DTO.Student_DTO;
import com.example.entity.Student;

public interface StudentSerive {
    public Student_DTO add(Student_DTO std);
    public List<Student_DTO> getAllStudents();
    public Student_DTO getStudentById(int id);
    public Student_DTO patchStudentById(int id, Student_DTO studentDto);
    public Student_DTO updateStudentById(int id,Student_DTO dto);
    
    public void deleteStudentById(int id);
}
