package edu.miu.cs.cs425.studentmgmt;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.miu.cs.cs425.studentmgmt.model.Classroom;
import edu.miu.cs.cs425.studentmgmt.model.Student;
import edu.miu.cs.cs425.studentmgmt.model.Transcript;
import edu.miu.cs.cs425.studentmgmt.service.StudentService;

@SpringBootApplication
public class StudentmgmtApplication implements CommandLineRunner {

	@Autowired
	private StudentService studentService;

	public static void main(String[] args) {
		SpringApplication.run(StudentmgmtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello World SpringBoot");
		Student student = new Student("000-61-0001", "Anna", "Lynn", "Smith", 3.45,
				new SimpleDateFormat("yyyy/MM/dd").parse("2019/5/24"));

		Transcript transcript = new Transcript(null, "BS Computer Science", student);
		student.addTranscript(transcript);

		Classroom classroom = new Classroom(null, "McLaughlin building", "M105");
		student.setClassroom(classroom);

		studentService.saveStudent(student);
	}

}
