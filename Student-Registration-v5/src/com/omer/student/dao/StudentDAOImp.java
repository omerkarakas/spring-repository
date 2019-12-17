package com.omer.student.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.omer.student.entity.Student;

@Repository
public class StudentDAOImp implements StudentDAO {

	// inject hibernate session factory
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Student> getStudents() {
		
		// current hibernate sessin
		Session session = sessionFactory.getCurrentSession();
		
		// create query
		Query<Student> query = session.createQuery("from Student order by firstName",Student.class);
		
		// execute query and get list
		List<Student> students = query.getResultList();
		
		// return list
		return students;
	}

	@Override
	public void saveStudent(Student student) {

		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(student);
	}

	@Override
	public Student getStudent(int studentId) {

		Session session = sessionFactory.getCurrentSession();
		
		Student student = session.get(Student.class, studentId);
		
		return student;
	}

	@Override
	public void deleteStudent(int studentId) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("delete from Student where id = :studentId");
		query.setParameter("studentId", studentId);
		
		query.executeUpdate();
		
	}

	@Override
	public List<Student> searchStudents(String searchName) {
		
		Session session = sessionFactory.getCurrentSession();
        
        Query query = null;
        
        //
        // only search by name if theSearchName is not empty
        //
        if (searchName != null && searchName.trim().length() > 0) {

            // search for firstName or lastName ... case insensitive
            query =session.createQuery("from Student where lower(firstName) like :name or lower(lastName) like :name", Student.class);
            query.setParameter("name", "%" + searchName.toLowerCase() + "%");

        }
        else {
            // theSearchName is empty ... so just get all customers
            query =session.createQuery("from Student", Student.class);            
        }
        
        // execute query and get result list
        List<Student> students = query.getResultList();
                
        // return the results        
        return students;


	}

}
