package com.demo.service;

import java.util.List;

import com.demo.entity.Student;

public interface StudentService {
	public List<Student> queryStudent(Student student);
	public abstract List<Student> queryAllStudent();
	public void deleteStudentBySno(String sno);
	public void insertStudent(Student student); 
	public void updatestudentBySno(Student student);
	
}
