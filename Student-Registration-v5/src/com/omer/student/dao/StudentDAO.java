package com.omer.student.dao;

import java.util.List;

import com.omer.student.entity.Student;

public interface StudentDAO {

	public List<Student> getStudents();

	//v2
	public void saveStudent(Student student);

	public Student getStudent(int studentId);

	public void deleteStudent(int studentId);

	public List<Student> searchStudents(String searchName);
}
