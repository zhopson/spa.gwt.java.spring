package com.my.mywebapp.server.web;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.my.mywebapp.shared.models.People;
import com.my.mywebapp.server.services.PeopleService;

@RestController
//@RequestMapping("/rest/getall/")
public class PeopleController {
	
	final static Logger logger = LoggerFactory.getLogger(PeopleController.class);
        PeopleService peopleService = new PeopleService();
	
//	List<Todo> todoList = new ArrayList<>();
	
	public PeopleController(){
//		todoList.add(new Todo("Todo #1"));
//		todoList.add(new Todo("Todo #2"));
//		todoList.add(new Todo("Todo #3"));
	}
    @RequestMapping(value = "/rest/getall/",method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<People> Getall() {
        List<People> peoples = peopleService.findAllPeoples();
        return peoples;
    }
}
