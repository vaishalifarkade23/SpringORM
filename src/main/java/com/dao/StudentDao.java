package com.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.entities.Student;

public class StudentDao
{
	private HibernateTemplate hibernateTemplete;
	
	
	public HibernateTemplate getHibernateTemplete() {
		return hibernateTemplete;
	}


	public void setHibernateTemplete(HibernateTemplate hibernateTemplete) {
		this.hibernateTemplete = hibernateTemplete;
	}


	//save method
	@Transactional
	public int insert(Student student)
	{
		Integer i=(Integer) this.hibernateTemplete.save(student);
		
		return i;
	}
	
	//get single data(object)
	public Student  getStudent(int sid)
	{
		Student student = this.hibernateTemplete.get(Student.class,sid);
		return student;
	}
	
	//get all student(all row)
	public List<Student> getAllStudents()
	{
		List<Student> students = this.hibernateTemplete.loadAll(Student.class);
		return students;
	}
	
	//detete
	  @Transactional
	public void deleteStudent(int sid)
	{
		Student student = this.hibernateTemplete.get(Student.class, sid);
		this.hibernateTemplete.delete(student);
	}
	
	//update
	 @Transactional
	public void updateStudent(Student student)
	{
		this.hibernateTemplete.update(student);
	}

}
