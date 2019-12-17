package com.omer.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.omer.student.dao.StudentDAO;
import com.omer.student.entity.Student;

@Service
public class StudentServiceImp implements StudentService {

	@Autowired
	private StudentDAO studentDAO;
	
	@Override
	@Transactional
	public List<Student> getStudents() {

		return studentDAO.getStudents();
	}

	//v2
	@Override
	@Transactional
	public void saveStudent(Student student) {

		studentDAO.saveStudent(student);
		
	}

	@Override
	@Transactional
	public Student getStudent(int studentId) {

		return studentDAO.getStudent(studentId);
	}

	@Override
	@Transactional
	public void deleteStudent(int studentId) {

		studentDAO.deleteStudent(studentId);
		
	}

	@Override
    @Transactional
	public List<Student> searchStudents(String searchName) {
		// TODO Auto-generated method stub
		return studentDAO.searchStudents(searchName);
	}

}
