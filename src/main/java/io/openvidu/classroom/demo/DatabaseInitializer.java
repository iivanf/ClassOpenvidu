package io.openvidu.classroom.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import io.openvidu.classroom.demo.lesson.Lesson;
import io.openvidu.classroom.demo.lesson.LessonRepository;
import io.openvidu.classroom.demo.user.User;
import io.openvidu.classroom.demo.user.UserRepository;

@Controller
public class DatabaseInitializer implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private LessonRepository lessonRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		//Sample users
		User user1 = new User("student1@gmail.com", "pass", "Iván Ferro", "ROLE_STUDENT");
		User user2 = new User("student2@gmail.com", "pass", "Pedro Vázquez", "ROLE_STUDENT");
		User user3 = new User("teacher@gmail.com",  "pass", "Yolanda", "ROLE_TEACHER");

		
		//Saving users
		userRepository.save(user1);
		userRepository.save(user2);
		userRepository.save(user3);
		
		//Sample lessons
		Lesson c1 = new Lesson("SMM TEORIA !!", user3);
		Lesson c2 = new Lesson("SMM GRUPO-B !!", user3);
		Lesson c3 = new Lesson("SMM GRUPO-C !!", user3);
		
		c1.getAttenders().add(user1);
		c1.getAttenders().add(user2);
		c1.getAttenders().add(user3);
		
		c2.getAttenders().add(user1);
		c2.getAttenders().add(user3);

		c3.getAttenders().add(user1);
		c3.getAttenders().add(user2);
		c3.getAttenders().add(user3);
		
		//Saving lessons
		lessonRepository.save(c1);
		lessonRepository.save(c2);
		lessonRepository.save(c3);
	}

}
