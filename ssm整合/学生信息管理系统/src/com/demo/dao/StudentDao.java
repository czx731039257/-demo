package com.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.demo.entity.Student;

public interface StudentDao { 
	public abstract List<Student> queryStudent(Student student);
	public abstract List<Student> queryAllStudent();
	public abstract void deleteStudentBySno(String sno);
	public abstract void insertStudent(Student student);
	public abstract void updatestudentBySno(Student student);
}
