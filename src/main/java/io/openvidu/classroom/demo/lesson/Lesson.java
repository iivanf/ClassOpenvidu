package io.openvidu.classroom.demo.lesson;

import java.util.Set;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonView;

import io.openvidu.classroom.demo.user.User;
import jdk.jfr.BooleanFlag;

@Entity
public class Lesson {
	
	public interface SimpleCourseList {}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonView(SimpleCourseList.class)
	private long id;
	
	@JsonView(SimpleCourseList.class)
	private String title;

	@ManyToOne
	private User teacher;

	@ManyToMany
	private Set<User> attenders;

	@JsonView(SimpleCourseList.class)
	private Boolean slow;
	
	@ManyToMany
	private Set<User> hand;

	public Lesson() {}
	
	public Lesson(String title, User teacher) {
		this.title = title;
		this.teacher = teacher;
		this.attenders = new HashSet<>();
		this.slow = false;
		this.hand = new HashSet<>();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public User getTeacher() {
		return teacher;
	}

	public void setTeacher(User teacher) {
		this.teacher = teacher;
	}

	public Set<User> getAttenders() {
		return attenders;
	}

	public void setAttenders(Set<User> attenders) {
		this.attenders = attenders;
	}

	public Set<User> getHand() {
		return hand;
	}

	public void setHand(Set<User> hand) {
		this.hand = hand;
	}

	public Boolean getSlow() {
		return slow;
	}

	public void setSlow(Boolean slow) {
		this.slow = slow;
	}
	
	//To make 'user.getLesson().remove(lesson)' possible
	@Override
	public boolean equals(Object other){
	    if (other == null) return false;
	    if (other == this) return true;
	    if (!(other instanceof Lesson))return false;
	    Lesson otherCourse = (Lesson)other;
	    return (otherCourse.id == this.id);
	}
}
