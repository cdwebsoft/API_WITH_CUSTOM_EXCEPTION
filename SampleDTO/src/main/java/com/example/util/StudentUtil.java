package com.example.util;

import org.springframework.stereotype.Component;

import com.example.DTO.Student_DTO;
import com.example.entity.Student;
@Component
public class StudentUtil {
     
	 public Student dtoToEntity(Student_DTO std) {
		 
		 if (std == null) {
	            throw new IllegalArgumentException("Student_DTO cannot be null");
	        }
		 Student st = new Student();
		 st.setId(std.getId());
         st.setName(std.getUser_name());
         st.setAddress(std.getAddress());
         st.setEmail(std.getEmail());
         System.out.println("uit-d----->"+st);
         return st;
		 
	 }
	 
	 
	 public Student_DTO entityToDto(Student st) {
		 if (st == null) {
	            throw new IllegalArgumentException("Student cannot be null");
	        }
		 
		 Student_DTO std = new Student_DTO();
		 std.setId(st.getId());
		 std.setUser_name(st.getName());
		 std.setAddress(st.getAddress());
		 std.setEmail(st.getEmail());
		// System.out.println("uit-e----->"+std);
        return std;		 
	 }
}
