package com.study.jpa.service;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.study.jpa.entity.SchoolEntity;
import com.study.jpa.entity.StudentEntity;
import com.study.jpa.entity.TeacherEntity;
import com.study.jpa.repository.GroupRepository;
import com.study.jpa.repository.SchoolRepository;
import com.study.jpa.repository.StudentRepository;
import com.study.jpa.repository.TeacherRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TestService {

	final private GroupRepository   groupRepository;
	final private TeacherRepository teacherRepository;
	final private SchoolRepository  schoolRepository;
	final private StudentRepository studentRepository;

//	@PostConstruct
	public void testInit() {

		Random random = new Random();

		// 테스트용 학교 추가
		for (int i = 0; i < 5; i++) {
			String name = "testschool" + i;

			if (checkSchoolName(name)) {
				SchoolEntity school = new SchoolEntity();

				school.setName(name);

				schoolRepository.save(school);

			}
		}

		// 테스트용 학생 추가

		if (checkStudent()) {
			for (int i = 0; i < 50; i++) {

				SchoolEntity  school  = schoolRepository.findByName("testschool" + random.nextInt(5));
				StudentEntity student = new StudentEntity();

				student.setAge(random.nextInt(6) + 8);
				student.setGrade(random.nextInt(6) + 1);
				student.setName("test" + i);
				studentRepository.save(student);
				school.getStudentEntityList()
					.add(student);

			}
		}

		// 테스트용 선생님 추가

		if (checkTeacher()) {

			String[] subject = { "Korean", "Math", "History", "Science", "Society", "English" };

			for (int i = 0; i < 20; i++) {

				SchoolEntity  school = schoolRepository.findByName("testschool" + random.nextInt(5));
				TeacherEntity teacher = new TeacherEntity();

				
				teacher.setName("teacher" + i);
				teacher.setAge(random.nextInt(40) + 20);
				teacher.setSubject(subject[random.nextInt(subject.length)]);
				teacher.setSchoolEntity(school);
				teacherRepository.save(teacher);
				school.getTeacherEntityList()
					.add(teacher);

			}

		}

	}

	public Object findeSchool() {
		return schoolRepository.findById((long) 2);
	}
	
	public Object findTeacher() {
		return teacherRepository.findAll();
	}

	private boolean checkSchoolName(String name) {

		if (schoolRepository.findByName(name) == null) {
			return true;
		} else {
			return false;
		}

	}

	private boolean checkStudent() {

		if (studentRepository.findAll()
			.isEmpty()) {
			return true;
		} else {
			return false;
		}

	}

	private boolean checkTeacher() {

		if (teacherRepository.findAll()
			.isEmpty()) {
			return true;
		} else {
			return false;
		}

	}

}
