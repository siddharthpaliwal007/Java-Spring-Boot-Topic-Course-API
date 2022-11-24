package io.demoproject.topics;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicservice; 
		
	@RequestMapping("/topics")
	public List<Topic> getAllTopics(){
		return topicservice.getAllTopics();
	}
	
	@RequestMapping("/topics/{id}")
	public Optional<Topic> getTopic(@PathVariable String id){
		return topicservice.getTopic(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topic")
	public void addTopic(@RequestBody Topic topic) {
		topicservice.addTopic(topic); 
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topic/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		topicservice.updateTopic(topic,id); 
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topic/{id}")
	public void addTopic(@PathVariable String id) {
		topicservice.deleteTopic(id); 
	}
}
