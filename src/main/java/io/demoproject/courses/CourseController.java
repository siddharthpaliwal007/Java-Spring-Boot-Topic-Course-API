package io.demoproject.courses;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.demoproject.topics.Topic;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseservice; 
		
	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable String id){
		return courseservice.getAllCourses(id);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{id}")
	public Optional<Course> getCourse(@PathVariable String id){
		return courseservice.getCourse(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topic/{topicId}/courses")
	public void addTopic(@RequestBody Course course,@PathVariable String topicId ) {
		course.setTopic(new Topic(topicId,"",""));
		courseservice.addCourse(course); 
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topic/{topicId}/courses/{id}")
	public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String id) {
		course.setTopic(new Topic(topicId,"",""));
		courseservice.updateCourse(course); 
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topic/{topicId}/courses/{id}")
	public void addTopic(@PathVariable String id) {
		courseservice.deleteCourse(id); 
	}
}
