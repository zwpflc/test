package com.zwp.common.service;

import org.springframework.stereotype.Service;

import com.zwp.common.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Override
	public Student selectStudentById(int id) {
		// TODO Auto-generated method stub
		return new Student(1,"test",10);
	}

}
