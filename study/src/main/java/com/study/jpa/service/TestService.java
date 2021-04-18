package com.study.jpa.service;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.study.jpa.entity.SchoolEntity;
import com.study.jpa.entity.StudentEntity;
import com.study.jpa.repository.GroupRepository;
import com.study.jpa.repository.SchoolRepository;
import com.study.jpa.repository.StudentRepository;
import com.study.jpa.repository.TeacherRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TestService {

	final private GroupRepository groupRepository;
	final private TeacherRepository teacherRepository;
	final private SchoolRepository schoolRepository;
	final private StudentRepository studentRepository;

	public void testInit() {
		Random random = new Random();
		for (int i = 0; i < 5; i++) {
			String name = "testschool" + i;

			if (checkSchoolName(name)) {
				SchoolEntity school = new SchoolEntity();

				school.setName(name);

				schoolRepository.save(school);

			}
		}

		for (int i = 0; i < 10; i++) {
			SchoolEntity school = schoolRepository.findByName("testschool" + random.nextInt(5));
			StudentEntity student = new StudentEntity();
			
			student.setAge(10);
			student.setGrade(5);
			student.setName("test"+i);
			studentRepository.save(student);
			school.getStudentEntityList().add(student);

		}

	}
	
	public Object testFind() {
		return schoolRepository.findById((long) 2);
	}

	private boolean checkSchoolName(String name) {

		if (schoolRepository.findByName(name) == null) {
			return true;
		} else {
			return false;
		}

	}

}
